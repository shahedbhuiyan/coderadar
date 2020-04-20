package io.reflectoring.coderadar.analyzer.checkstyle;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains readable descriptions of all checkstyle metrics. Note that these descriptions
 * are only correct assuming that checkstyle is configured with it's default values. Some metrics
 * have been left out.
 */
public class CheckstyleMetricDescriptions {

  public static final String ABSTRACT_CLASS_NAME =
      "Abstract class name does not match the Java naming convention.";

  public static final String ANON_INNER_LENGTH = "This anonymous class is longer than 20 lines.";

  public static final String ARRAY_TRAILING_COMMA =
      "Remove the trailing comma from this array initialization.";

  public static final String ARRAY_TYPE_STYLE = "Define this array using Java style.";

  public static final String AVOID_INLINE_CONDITIONALS = "Avoid inlining conditional statements.";

  public static final String AVOID_NESTED_BLOCKS = "Remove the unnecessary block.";

  public static final String AVOID_START_IMPORT = "Avoid using the start import notation.";

  public static final String BOOLEAN_EXPRESSION_COMPLEXITY =
      "This boolean expression is too complex.";

  public static final String CLASS_DATA_ABSTRACTION_COUPLING =
      "The data abstraction coupling is larger than 7 (More than 7 fields are external classes).";

  public static final String CLASS_FAN_OUT_COMPLEXITY =
      "This class relies on more than 20 external classes.";

  public static final String CONSTANT_NAME =
      "This static/final modifiers on this field are not ordered properly.";

  public static final String COVARIANT_EQUALS =
      "Equals should be defined as boolean equals(java.lang.Object).";

  public static final String CROSS_LANGUAGE_REGEXP_HEADER =
      "CrossLanguageRegexpHeader."; // Unused??

  public static final String CYCLOMATIC_COMPLEXITY =
      "This method exceeds the complexity threshold of 10.";

  public static final String DECLARATION_ORDER =
      "The order of declaration does not match Java convention.";

  public static final String DEFAULT_COMES_LAST =
      "The default case of the switch statement should be last.";

  public static final String DESCENDANT_TOKEN = "DescendantToken."; // Let's ignore this one for now

  public static final String DESIGN_FOR_EXTENSION =
      "Methods should be either abstract, final or with an empty implementation.";

  public static final String DOUBLE_CHECKED_LOCKING =
      "Do not use the DCL idiom to achieve synchronization.";

  public static final String EMPTY_BLOCK = "Remove this empty block.";

  public static final String EMPTY_FOR_INITIALIZER_PAD =
      "Remove the padding for this empty loop initializer.";

  public static final String EMPTY_FOR_ITERATOR_PAD = "Remove the padding for this empty iterator.";

  public static final String EMPTY_STATEMENT = "Remove this empty statement;.";

  public static final String ENTITY_BEAN =
      "This class does not satisfy the EntityBean requirements.";

  public static final String EQUALS_HASH_CODE = "Override hashCode() if overriding equals().";

  public static final String EXECUTABLE_STATEMENT_COUNT =
      "This block of code has too many executable statements.";

  public static final String EXPLICIT_INITIALIZATION =
      "Initialize this object/primitive with a default value.";

  public static final String FALL_THROUGH = "Missing break/return/throw or continue statement.";

  public static final String FILE_LENGTH = "This file is longer than 2000 lines.";

  public static final String FINAL_CLASS =
      "Classes with only final constructors should be declared final.";

  public static final String FINAL_LOCAL_VARIABLE = "Make this variable final.";

  public static final String FINAL_PARAMETERS = "Make this parameter final.";

  public static final String FINAL_STATIC = "All static fields should be final as well.";

  public static final String GENERIC_ILLEGAL_REGEXP =
      "GenericIllegalRegexp."; // Let's ignore this one for now

  public static final String HEADER = "Header."; // Let's ignore this one for now

  public static final String HIDDEN_FIELD = "This variable/parameter shadows a field.";

  public static final String HIDE_UTILITY_CLASS_CONSTRUCTOR =
      "Classes with only static methods should not have a public constructor.";

  public static final String ILLEGAL_CATCH =
      "Catching java.lang.Error, java.lang.RuntimeException or java.lang.Exception is not allowed.";

  public static final String ILLEGAL_IMPORT = "Illegal import.";

  public static final String ILLEGAL_INSTANTIATION = "Use factory method for initialization.";

  public static final String ILLEGAL_THROWS =
      "Throwing java.lang.Error or java.lang.RuntimeException is not allowed.";

  public static final String ILLEGAL_TOKEN = "Illegal Token.";

  public static final String ILLEGAL_TOKEN_TEXT = "Illegal token text.";

  public static final String ILLEGAL_TYPE = "This class cannot be used as a type.";

  public static final String IMPORT_CONTROL = "ImportControl."; // Let's ignore this one for now

  public static final String IMPORT_ORDER = "Incorrect import order.";

  public static final String INDENTATION = "Incorrect indentation.";

  public static final String INNER_ASSIGNMENT = "Do not use assignment in subexpressions.";

  public static final String INTERFACE_IS_TYPE = "Interface should be type (contain methods).";

  public static final String JUNIT_TEST_CASE =
      "Method declaration does not follow JUnit convention.";

  public static final String JAVA_NCSS = "Reduce the amount of code in this method/class.";

  public static final String JAVADOC_METHOD = "Missing or incorrect javadoc.";

  public static final String JAVADOC_STYLE =
      "Incomplete description, missing closing tags or incorrect punctuation.";

  public static final String JAVADOC_TYPE = "Missing or incorrect javadoc.";

  public static final String JAVADOC_VARIABLE = "Missing javadoc.";

  public static final String LEFT_CURLY = "Put left curly braces on the same line.";

  public static final String LINE_LENGTH = "This line is too long.";

  public static final String LOCAL_FINAL_VARIABLE_NAME = "";

  public static final String LOCAL_HOME_INTERFACE =
      "This interface does not satisfy requirements of EJBLocalHome.";

  public static final String LOCAL_INTERFACE =
      "This interface does not satisfy the requirements of EJBLocalObject.";

  public static final String LOCAL_VARIABLE_NAME =
      "The name of this variable does not follow Java convention.";

  public static final String MAGIC_NUMBER = "Remove the use of this magic number.";

  public static final String MEMBER_NAME =
      "The name of this member variable does not follow Java convention.";

  public static final String MESSAGE_BEAN =
      "This class does not satisfy the requirements of MessageDrivenBean and/or MessageListener.";

  public static final String METHOD_LENGTH = "This method is longer than 150 lines.";

  public static final String METHOD_NAME =
      "The name of this method does not follow Java naming convention.";

  public static final String METHOD_PARAM_PAD = "Remove unnecessary padding.";

  public static final String MISSING_CTOR = "Non-abstract classes should define a constructor.";

  public static final String MISSING_SWITCH_DEFAULT =
      "Switch statement should have a default clause.";

  public static final String MODIFIED_CONTROL_VARIABLE =
      "For loop control variable is modified inside the loop.";

  public static final String MODIFIER_ORDER = "Incorrect modifier order.";

  public static final String MULTIPLE_STRING_LITERALS =
      "This string literal occurs multiple times within this file.";

  public static final String MULTIPLE_VARIABLE_DECLARATIONS =
      "Put each variable declaration in a separate statement/line.";

  public static final String MUTABLE_EXCEPTION = "Exceptions should be immutable.";

  public static final String NPATH_COMPLEXITY = "The NPath complexity is larger than 200.";

  public static final String NEED_BRACES = "Surround this block of code with braces.";

  public static final String NESTED_IF_DEPTH = "Do not nest if-else blocks deeper than 1.";

  public static final String NESTED_TRY_DEPTH = "Do not nest try blocks deeper than 1.";

  public static final String NEWLINE_AT_END_OF_FILE = "Add a newline to the end of this file.";

  public static final String NO_WHITESPACE_AFTER = "Remove unnecessary whitespace.";

  public static final String NO_WHITESPACE_BEFORE = "Remove unnecessary whitespace.";

  public static final String OPERATOR_WRAP =
      "Operator wrap."; // TODO: Not quite sure about this one

  public static final String PACKAGE_DECLARATION = "Package declaration must be present.";

  public static final String PACKAGE_HTML = "Packages should be documented.";

  public static final String PACKAGE_NAME = "Package name does not match Java convention.";

  public static final String PARAMETER_ASSIGNMENT = "Do not assign new values to parameters.";

  public static final String PARAMETER_NAME = "Parameter name does not match Java convention.";

  public static final String PARAMETER_NUMBER = "This method has more than 7 parameters.";

  public static final String PAREN_PAD = "Remove unnecessary space.";

  public static final String REDUNDANT_IMPORT = "Remove redundant import.";

  public static final String REDUNDANT_MODIFIER = "Remove redundant modifier.";

  public static final String REDUNDANT_THROWS = "Remove redundant throw.";

  public static final String REGEXP = "Regexp."; // Let's ignore this one for now

  public static final String REGEXP_HEADER = "RegexpHeader."; // Let's ignore this one for now

  public static final String REMOTE_HOME_INTERFACE =
      "This interface does not satisfy the requirements of EJBHome.";

  public static final String REMOTE_INTERFACE =
      "This interface does not satisfy the requirements of EJBObject.";

  public static final String REQUIRE_THIS = "Use 'this'.";

  public static final String REQUIRED_REGEXP = "."; // Let's ignore this one for now;

  public static final String RETURN_COUNT = "This method has more than 2 return statements.";

  public static final String RIGHT_CURLY = "Right curly brace should be on the same line.";

  public static final String SESSION_BEAN =
      "This class does not satisfy the requirements of SessionBean.";

  public static final String SIMPLIFY_BOOLEAN_EXPRESSION =
      "This boolean expression is too complex.";

  public static final String SIMPLIFY_BOOLEAN_RETURN = "This boolean expression is too complex.";

  public static final String STATIC_VARIABLE_NAME =
      "This non-final static variable does not follow the Java naming convention.";

  public static final String STRICT_DUPLICATE_CODE = "Duplicate code.";

  public static final String STRING_LITERAL_EQUALITY = "Use equals() with string literals.";

  public static final String SUPER_CLONE = "Call super.clone() when overriding clone().";

  public static final String SUPER_FINALIZE = "Call super.finalize() when overriding finalize().";

  public static final String TAB_CHARACTER = "Do not use tabs.";

  public static final String THIS_PARAMETER = "'this' should not be a parameter.";

  public static final String THIS_RETURN = "Do not return 'this' in a bean method.";

  public static final String THROWS_COUNT =
      "Do not declare more than one exception thrown by this method.";

  public static final String TODO_COMMENT = "Complete the task associated with this TODO.";

  public static final String TRAILING_COMMENT = "Comments should be the only thing on this line.";

  public static final String TRANSLATION =
      "Inconsistent keys in properties file."; // TODO: Not quite sure here either

  public static final String TYPE_NAME = "Type name does not follow Java convention.";

  public static final String TYPECAST_PAREN_PAD = "Remove unnecessary space.";

  public static final String UNCOMMENTED_MAIN = "This main method is not commented.";

  public static final String UNNECESSARY_PARENTHESES = "Remove unnecessary parentheses.";

  public static final String UNUSED_IMPORTS = "Remove unused imports.";

  public static final String UPPER_ELL = "Long constants should end with 'L'.";

  public static final String VISIBILITY_MODIFIER = "Make this class member private.";

  public static final String WHITESPACE_AFTER = "Add a whitespace after this comma.";

  public static final String WHITESPACE_AROUND = "Missing whitespace.";

  public static final String WRITE_TAG = "WriteTag."; // Let's ignore this one for now

  public static final String OUTER_TYPE_FILENAME = "Class name does not match file name.";

  public static final String CUSTOM_IMPORT_ORDER = "Incorrect import order.";

  public static final String JAVADOC_PACKAGE = "Packages should be documented.";

  public static final String AVOID_STATIC_IMPORT = "Do not use static imports.";

  private static final Map<String, String> mapping = new HashMap<>();

  public CheckstyleMetricDescriptions() {
    mapping.put("AbstractClassNameCheck", ABSTRACT_CLASS_NAME);
    mapping.put("AnonInnerLengthCheck", ANON_INNER_LENGTH);
    mapping.put("ArrayTrailingCommaCheck", ARRAY_TRAILING_COMMA);
    mapping.put("ArrayTypeStyleCheck", ARRAY_TYPE_STYLE);
    mapping.put("AvoidInlineConditionalsCheck", AVOID_INLINE_CONDITIONALS);
    mapping.put("AvoidNestedBlocksCheck", AVOID_NESTED_BLOCKS);
    mapping.put("AvoidStarImportCheck", AVOID_START_IMPORT);
    mapping.put("BooleanExpressionComplexityCheck", BOOLEAN_EXPRESSION_COMPLEXITY);
    mapping.put("ClassDataAbstractionCouplingCheck", CLASS_DATA_ABSTRACTION_COUPLING);
    mapping.put("ClassFanOutComplexityCheck", CLASS_FAN_OUT_COMPLEXITY);
    mapping.put("ConstantNameCheck", CONSTANT_NAME);
    mapping.put("CovariantEqualsCheck", COVARIANT_EQUALS);
    mapping.put("CyclomaticComplexityCheck", CYCLOMATIC_COMPLEXITY);
    mapping.put("DeclarationOrderCheck", DECLARATION_ORDER);
    mapping.put("DefaultComesLastCheck", DEFAULT_COMES_LAST);
    mapping.put("DescendantTokenCheck", DESCENDANT_TOKEN);
    mapping.put("DesignForExtensionCheck", DESIGN_FOR_EXTENSION);
    mapping.put("DoubleCheckedLockingCheck", DOUBLE_CHECKED_LOCKING);
    mapping.put("EmptyBlockCheck", EMPTY_BLOCK);
    mapping.put("EmptyForInitializerPadCheck", EMPTY_FOR_INITIALIZER_PAD);
    mapping.put("EmptyForIteratorPadCheck", EMPTY_FOR_ITERATOR_PAD);
    mapping.put("EmptyStatementCheck", EMPTY_STATEMENT);
    mapping.put("EntityBeanCheck", ENTITY_BEAN);
    mapping.put("EqualsHashCodeCheck", EQUALS_HASH_CODE);
    mapping.put("ExecutableStatementCountCheck", EXECUTABLE_STATEMENT_COUNT);
    mapping.put("ExplicitInitializationCheck", EXPLICIT_INITIALIZATION);
    mapping.put("FallThroughCheck", FALL_THROUGH);
    mapping.put("FileLengthCheck", FILE_LENGTH);
    mapping.put("FinalClassCheck", FINAL_CLASS);
    mapping.put("FinalLocalVariableCheck", FINAL_LOCAL_VARIABLE);
    mapping.put("FinalParametersCheck", FINAL_PARAMETERS);
    mapping.put("FinalStaticCheck", FINAL_STATIC);
    mapping.put("GenericIllegalRegexpCheck", GENERIC_ILLEGAL_REGEXP);
    mapping.put("HiddenFieldCheck", HIDDEN_FIELD);
    mapping.put("HideUtilityClassConstructorCheck", HIDE_UTILITY_CLASS_CONSTRUCTOR);
    mapping.put("IllegalCatchCheck", ILLEGAL_CATCH);
    mapping.put("IllegalImportCheck", ILLEGAL_IMPORT);
    mapping.put("IllegalInstantiationCheck", ILLEGAL_INSTANTIATION);
    mapping.put("IllegalThrowsCheck", ILLEGAL_THROWS);
    mapping.put("IllegalTokenCheck", ILLEGAL_TOKEN);
    mapping.put("IllegalTokenTextCheck", ILLEGAL_TOKEN_TEXT);
    mapping.put("IllegalTypeCheck", ILLEGAL_TYPE);
    mapping.put("ImportOrderCheck", IMPORT_ORDER);
    mapping.put("IndentationCheck", INDENTATION);
    mapping.put("InnerAssignmentCheck", INNER_ASSIGNMENT);
    mapping.put("InterfaceIsTypeCheck", INTERFACE_IS_TYPE);
    mapping.put("JUnitTestCaseCheck", JUNIT_TEST_CASE);
    mapping.put("JavaNCSSCheck", JAVA_NCSS);
    mapping.put("JavadocMethodCheck", JAVADOC_METHOD);
    mapping.put("JavadocStyleCheck", JAVADOC_STYLE);
    mapping.put("JavadocTypeCheck", JAVADOC_TYPE);
    mapping.put("JavadocVariableCheck", JAVADOC_VARIABLE);
    mapping.put("LeftCurlyCheck", LEFT_CURLY);
    mapping.put("LineLengthCheck", LINE_LENGTH);
    mapping.put("LocalFinalVariableNameCheck", LOCAL_FINAL_VARIABLE_NAME);
    mapping.put("LocalHomeInterfaceCheck", LOCAL_HOME_INTERFACE);
    mapping.put("LocalInterfaceCheck", LOCAL_INTERFACE);
    mapping.put("LocalVariableNameCheck", LOCAL_VARIABLE_NAME);
    mapping.put("MagicNumberCheck", MAGIC_NUMBER);
    mapping.put("MemberNameCheck", MEMBER_NAME);
    mapping.put("MessageBeanCheck", MESSAGE_BEAN);
    mapping.put("MethodLengthCheck", METHOD_LENGTH);
    mapping.put("MethodNameCheck", METHOD_NAME);
    mapping.put("MethodParamPadCheck", METHOD_PARAM_PAD);
    mapping.put("MissingCtorCheck", MISSING_CTOR);
    mapping.put("MissingSwitchDefaultCheck", MISSING_SWITCH_DEFAULT);
    mapping.put("ModifiedControlVariableCheck", MODIFIED_CONTROL_VARIABLE);
    mapping.put("ModifierOrderCheck", MODIFIER_ORDER);
    mapping.put("MultipleStringLiteralsCheck", MULTIPLE_STRING_LITERALS);
    mapping.put("MultipleVariableDeclarationsCheck", MULTIPLE_VARIABLE_DECLARATIONS);
    mapping.put("MutableExceptionCheck", MUTABLE_EXCEPTION);
    mapping.put("NPathComplexityCheck", NPATH_COMPLEXITY);
    mapping.put("NeedBracesCheck", NEED_BRACES);
    mapping.put("NestedIfDepthCheck", NESTED_IF_DEPTH);
    mapping.put("NestedTryDepthCheck", NESTED_TRY_DEPTH);
    mapping.put("NewlineAtEndOfFileCheck", NEWLINE_AT_END_OF_FILE);
    mapping.put("NoWhitespaceAfterCheck", NO_WHITESPACE_AFTER);
    mapping.put("NoWhitespaceBeforeCheck", NO_WHITESPACE_BEFORE);
    mapping.put("OperatorWrapCheck", OPERATOR_WRAP);
    mapping.put("PackageDeclarationCheck", PACKAGE_DECLARATION);
    mapping.put("PackageHtmlCheck", PACKAGE_HTML);
    mapping.put("PackageNameCheck", PACKAGE_NAME);
    mapping.put("ParameterAssignmentCheck", PARAMETER_ASSIGNMENT);
    mapping.put("ParameterNameCheck", PARAMETER_NAME);
    mapping.put("ParameterNumberCheck", PARAMETER_NUMBER);
    mapping.put("ParenPadCheck", PAREN_PAD);
    mapping.put("RedundantImportCheck", REDUNDANT_IMPORT);
    mapping.put("RedundantModifierCheck", REDUNDANT_MODIFIER);
    mapping.put("RedundantThrowsCheck", REDUNDANT_THROWS);
    mapping.put("RemoteHomeInterfaceCheck", REMOTE_HOME_INTERFACE);
    mapping.put("RemoteInterfaceCheck", REMOTE_INTERFACE);
    mapping.put("RequireThisCheck", REQUIRE_THIS);
    mapping.put("ReturnCountCheck", RETURN_COUNT);
    mapping.put("RightCurlyCheck", RIGHT_CURLY);
    mapping.put("SessionBeanCheck", SESSION_BEAN);
    mapping.put("SimplifyBooleanExpressionCheck", SIMPLIFY_BOOLEAN_EXPRESSION);
    mapping.put("SimplifyBooleanReturnCheck", SIMPLIFY_BOOLEAN_RETURN);
    mapping.put("StaticVariableNameCheck", STATIC_VARIABLE_NAME);
    mapping.put("StrictDuplicateCodeCheck", STRICT_DUPLICATE_CODE);
    mapping.put("StringLiteralEqualityCheck", STRING_LITERAL_EQUALITY);
    mapping.put("SuperCloneCheck", SUPER_CLONE);
    mapping.put("SuperFinalizeCheck", SUPER_FINALIZE);
    mapping.put("TabCharacterCheck", TAB_CHARACTER);
    mapping.put("ThisParameterCheck", THIS_PARAMETER);
    mapping.put("ThisReturnCheck", THIS_RETURN);
    mapping.put("ThrowsCountCheck", THROWS_COUNT);
    mapping.put("TodoCommentCheck", TODO_COMMENT);
    mapping.put("TrailingCommentCheck", TRAILING_COMMENT);
    mapping.put("TranslationCheck", TRANSLATION);
    mapping.put("TypeNameCheck", TYPE_NAME);
    mapping.put("TypecastParenPadCheck", TYPECAST_PAREN_PAD);
    mapping.put("UncommentedMainCheck", UNCOMMENTED_MAIN);
    mapping.put("UnnecessaryParenthesesCheck", UNNECESSARY_PARENTHESES);
    mapping.put("UnusedImportsCheck", UNUSED_IMPORTS);
    mapping.put("UpperEllCheck", UPPER_ELL);
    mapping.put("VisibilityModifierCheck", VISIBILITY_MODIFIER);
    mapping.put("WhitespaceAfterCheck", WHITESPACE_AFTER);
    mapping.put("WhitespaceAroundCheck", WHITESPACE_AROUND);
    mapping.put("WriteTagCheck", WRITE_TAG);

    mapping.put("OuterTypeFilenameCheck", OUTER_TYPE_FILENAME);
    mapping.put("CustomImportOrderCheck", CUSTOM_IMPORT_ORDER);
    mapping.put("JavadocPackageCheck", JAVADOC_PACKAGE);
    mapping.put("AvoidStaticImportCheck", AVOID_STATIC_IMPORT);
  }

  public String get(String metricName) {
    String tempp = mapping.get(metricName);
    return mapping.get(metricName);
  }
}
