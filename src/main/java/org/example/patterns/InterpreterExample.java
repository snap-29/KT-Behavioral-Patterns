package org.example.patterns;

interface SearchExpression {

    boolean interpret(Document document);
}

class Document {

    private final String name;
    private final String tag;

    public Document(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }
}

class NameExpression implements SearchExpression {

    private final String expectedName;

    public NameExpression(String expectedName) {
        this.expectedName = expectedName;
    }

    @Override
    public boolean interpret(Document document) {
        return document.getName()
                .equalsIgnoreCase(expectedName);
    }
}

class TagExpression implements SearchExpression {

    private final String expectedTag;

    public TagExpression(String expectedTag) {
        this.expectedTag = expectedTag;
    }

    @Override
    public boolean interpret(Document document) {
        return document.getTag()
                .equalsIgnoreCase(expectedTag);
    }
}

class SearchParser {

    public SearchExpression parse(String query) {

        if (query.startsWith("NAME:")) {

            String value =
                    query.substring(5);

            return new NameExpression(value);
        }

        if (query.startsWith("TAG:")) {

            String value =
                    query.substring(4);

            return new TagExpression(value);
        }

        throw new IllegalArgumentException(
                "Неизвестная команда: " + query
        );
    }
}

public class InterpreterExample {

    public static void main(String[] args) {

        Document document =
                new Document(
                        "Java",
                        "programming"
                );

        SearchParser parser =
                new SearchParser();

        SearchExpression expression1 =
                parser.parse("NAME:Java");

        SearchExpression expression2 =
                parser.parse("TAG:programming");

        System.out.println(
                "По имени найдено: " +
                        expression1.interpret(document)
        );

        System.out.println(
                "По тегу найдено: " +
                        expression2.interpret(document)
        );
    }
}