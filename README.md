Piotr Szczepaniak's solution
=======================

Alternative approach
-------
During my work on this assignment, I've developed two, closely related solutions. I prefer the first one (available in `StringUtil.contains()`), for its straightforwardness, however the second one (`StringUtilAlt.contains()`) is slightly more concise.

Mutation tests
-------
Mutation testing has confirmed the 100% effectiveness and strength of unit tests:  
![img.png](src/main/resources/img.png)  
For a more detailed analysis, please refer to [/target/pit-reports/index.html](/target/pit-reports/index.html) after running `mvn clean test`.

---

DS interview assignment
=======================


Summary
-------
Repository contains job interview assignments at Dynamic Solutions.


Prerequisites
-------------

- JDK 8
- Maven 3


Implementation of `StringUtil.contains()`
------------------------------------------

Implement the `StringUtil.contains(String string, String pattern)` method to take two
input parameters. The method must verify if the first parameter contains a pattern passed
as the second parameter.

Implementation cannot use any standard library or third party utility methods operating
on strings (`String.matches()`, `String.contains()`, `String.indexOf()`, etc.) or regular expressions.
Methods like `String.toCharArray()`, `String.charAt()`, `String.length()`, `String.substring()`, etc. are allowed to use.

It is allowed to add any testing libraries of your choice, but the main framework (JUnit 5) should remain.

Exact requirements are specified in a JavaDoc for the implemented method. In case of doubts or
any clarifications are needed, do not hesitate to contact recruiters.
