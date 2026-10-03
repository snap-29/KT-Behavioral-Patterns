package org.example.patterns;

class EditorMemento {

    private final String text;

    public EditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class TextEditor {

    private String text = "";

    public void write(String text) {

        this.text += text;

        System.out.println(
                "Текущий текст: " + this.text
        );
    }

    public EditorMemento save() {

        System.out.println(
                "Состояние сохранено"
        );

        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {

        text = memento.getText();

        System.out.println(
                "Состояние восстановлено: " + text
        );
    }
}

class History {

    private EditorMemento savedState;

    public void save(EditorMemento memento) {
        savedState = memento;
    }

    public EditorMemento getSavedState() {
        return savedState;
    }
}

public class MementoExample {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        History history = new History();

        editor.write("Привет, ");
        editor.write("это мой текст.");

        history.save(editor.save());

        editor.write(" Новое изменение.");

        System.out.println();

        editor.restore(
                history.getSavedState()
        );
    }
}