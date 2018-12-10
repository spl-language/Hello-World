
grammar Hello; // співпадає з назвою файла

// Необхідні бібліотеки добавлені в заголовок парсера
@parser::header
{
import java.util.List;
import java.util.ArrayList;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;

import simpletruffle.HelloLanguage;

}

// Точка входу в парсер для аналізу заданого тексту програми
@parser::members
{
private HelloNodeFactory factory;
private Source source;

public static List<RootCallTarget> parseSL(HelloLanguage language, Source source) {
    HelloLexer lexer = new HelloLexer(CharStreams.fromString(source.getCharacters().toString()));
    HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
    parser.factory = new HelloNodeFactory(language, source);
    parser.source = source;
    parser.r();
    return parser.factory.getAllNodes();
}
}

r
:
'hello'
ID       { factory.createHelloNode($ID); } // викликається метод якому передається токен ID
 ;         // знаходить ключове слова після якого слідує ID
ID : [a-z]+ ;            // ланцюжок із маленький латинських букв
WS : [ \t\r\n]+ -> skip ; // пропустити пробіли, таби та новий рядок
