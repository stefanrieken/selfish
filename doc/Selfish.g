grammar Selfish;

start_rule	: code;

/* Antlr3 compatible grammar for Selfish             */
/* Note: for reference only. Parser written by hand. */

/* Unit: ExpressionParser */

code		: (expressionlist (';' expressionlist)*)? ;
expressionlist	: expression ((',')? expression)* ;
expression	: bracketed | delegation ;
bracketed	: '(' expressionlist ')' ;	/* NOTE: Means 'arglist' or 'precedence' depending on preceding (if dotInvocation: always interpret as arglist) */
delegation	: invocation;


/* Unit: InvocationParser */

invocation	: binaryGroup;
binaryGroup	: dotGroup (BNAME dotGroup)? ;		/* because we want 1 + [2.squared] instead of [1 + 2].squared */
dotGroup	: assoc ( '.' (BNAME|NAME) )? ;

/* Unit: AssociationParser */

assoc		: literal | definition | NAME ;	/* NAME aka reference. Rule: LHS cannot (directly) be BNAME because of ambiguity (e.g. '* = bla;') */
block		: '{' code '}' ;


/* Unit: DefinitionParser (= named definitions) */

definition	: attrDefinition | staticDef ;
attrDefinition	: attr (NAME|BNAME) (':' definitionValue)? ;
staticDef	: (NAME|BNAME) ':' definitionValue ;
definitionValue	: linkReference | literal;
linkReference	: ( '/' NAME )+ ;
attr		: '@' (NAME | block);		/* manual note: only static definitions allowed in this particular block */


/* Unit: LiteralParser */

literal		: block | NUMBER | STRING ;

/* Unit: Lexer */

NUMBER		: ('0'..'9')+ ;
STRING		: '"' ( ~'"' )* '"' ;		/* todo escape */
NAME		: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')* ;
BNAME		: ('!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+ ;

