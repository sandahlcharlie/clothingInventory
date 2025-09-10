In this assignment, you will practice writing Java code using files,
Objects, and arrays.

# Requirements

## Part 1: **Item** class

Start by choosing one sort of Item that is of interest to you. (For
example: vacation or travel information, real estate property, or
restaurants. But don't feel limited to these ideas!) [Do not use any of
the following as your Item: Person, Car, Student, Book, BankAccount,
Movie, Pet, Animal, Song, or Videogame.]{.underline}[^1]

Note: We use the term \<Item\> or \<Thing\> throughout this class with
the "\<\>" around it to mean that you should replace \<Item\> with the
name of [your]{.underline} item.

***[Name]{.underline}***: Give your **Item** class a meaningful name.
[Do not name your class **Thing** or **Item**.]{.underline}

***[Instance Variables]{.underline}***: Give your **\<Item\>** class
[exactly two private]{.underline} instance variables, a **String** and
an **Integer**. Give them meaningful names that describe the
characteristics of your \<Item\>.

***[Some methods]{.underline}***:

- **public \<Item\>(
  [String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html)
  s,
  [Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html)
  n )**

Constructs an **\<Item\>** object that that initializes the two instance
variables. The order of the input parameters must be **String** then
**Integer**.

- Implement getters and setters for all the instance variables of your
  **\<Item\>**.

- **public String toString()**

Returns a **String** representation of your **\<Item\>** where the
instance variables are on one line and tab-separated. Do not add any
text to the output of this method other than the values of the two
instance variables.

- **public boolean equals(\<Item\> o)**

compares your \<Item\> to the parameter **o** for equality. Two
\<Items\> are equal if all of their instance variables are equal. The
equality of string attributes should be case insensitive. For example,
\"MATH\", \"math\" and \"Math\" are equal. Note: to compare **String**
objects in Java use the **boolean
equalsIgnoreCase(****[String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html)
s)** method from the **String** class. For example, the following code
prints true:

> **String str1 = \"Hello\";**
>
> **String str2 = \"hello\";**
>
> **System.out.println(str1.equalsIgnoreCase(str2));**

## Part 2: Upload data from a text file to an array of **\<Item\>** objects

- Create a **.txt** file that includes data about a collection of items.
  Each line in the file represents one item where the string and integer
  separated by tab (e.g., **abc 10**). Add at least 20 lines to your
  text file. Make sure to repeat some of the string values in the file.

- Create another class in your project, called **\<Item\>ArrayDriver**.
  Use the name of your item instead of **\<Item\>**.

- In the main method, declare an array, called **\<Item\>Arr**, that can
  hold up to the number of items in your text file.

- In the main method, ask the user to enter file name then read the user
  input. Create a
  [**File**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/File.html)
  object using the input file name. Create a
  [**Scanner**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Scanner.html)
  object to read from the file.

- Write a loop to read the text file. You need to read one field from
  the file at a time. Basically, for each line in the text file, you
  will read the two fields in each row using the following **Scanner**
  methods: **next()** then **nextInt()**.

- Use the values read from one line from the file to instantiate an
  **\<Item\>** object then add that object to **\<Item\>Arr**.

- After uploading the data to the array, write a \'for\' loop to print
  on the screen all objects in **\<Item\>Arr** to make sure that the
  data to read correctly.

## Part 3: Methods to process **\<Item\>** array

Implement the following five methods in **\<Item\>ArrayDriver**. Test
the methods from the main method using **itemArr** as input. Remember:
string comparison is case insensitive.

- **public int overallAvg( \<Item\>\[\] a )**

Returns the average (arithmetic mean) of the **Integer** attributes of
all items in input array **a**.

- **public int count( \<Item\>\[\] a, \<Item\> o )**

Returns the number of **\<Item\>**s in the input array **a** that are
equal to the input **\<Item\> o**. Remember, two **\<Item\>**s are equal
if they have the same value for both instance variables, where
**String** variables are equal if they differ only in case.

- **public int groupAvg(\<Item\>\[\] a, String s)**

Returns the average of the **Integer** attributes of **\<Item\>s** with
**String** attribute equal to the input string. For example,
**groupAvg(itemArr,\"abc\")** returns the average of the **Integer**
attributes for all objects with **String** attribute equal to **abc**.

- **public \<Item\>\[\] lessThan( \<Item\>\[\] a,**
  **[Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html)
  i )**

Returns an array of **\<Item\>** objects that contains all objects with
Integer attribute less than the input **Integer**. For example,
**lessThan(itemArr, 50)** returns an array of items with **Integer**
attribute \< 50.

- **public void groupEdit( \<Item\>\[\] a,
  [String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html)
  s,
  [Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html)
  n )**

For each item in the input array with **String** attribute equal to the
input string, the method edits the **\<Item\>**'s **Integer** attribute
by adding **n** to the **Integer** value. Thus,
**groupEdit(itemArr,\"abc\",10)** adds 10 to the **Integer** values of
each **\<Item\>** in **itemArr** with **String** value **abc**.

# Grading

Your grade in this assignment is based on the following criteria:

- Your submission meets specifications as described above.

- You must use the exact same name (case matched) for all fields and
  methods as specified in the above description.

- The method input parameters must be in the same order as specified.

- The program is robust with no runtime errors or problems.

- You follow good programming style.

Rubric:

+----------+----------------------------------------------------------------------------------------------------+-------+-----------+
| **Part** | **Method or objective**                                                                            | **Out | **Score** |
|          |                                                                                                    | Of**  |           |
+==========+====================================================================================================+:=====:+:=========:+
| Part 1:  | \<Item\> is named properly                                                                         | 2     |           |
| Item     |                                                                                                    |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | \<Item\> has String variable, named meaningfully                                                   | 2     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | \<Item\> has Integer variable, named meaningfully                                                  | 1     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | constructor: **public \<Item\>(                                                                    | 2     |           |
|          | [String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html) s,    |       |           |
|          | [Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html) n   |       |           |
|          | )**                                                                                                |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | getters and setters for all instance variables                                                     | 1     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public String toString()**                                                                       | 1     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public boolean equals(\<Item\> o)**                                                              | 1     |           |
+----------+----------------------------------------------------------------------------------------------------+-------+-----------+
| Part 2:  | .txt file with 20+ items,                                                                          | 1     |           |
| Upload   | [**String**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html)   |       |           |
| data     | and                                                                                                |       |           |
|          | [**Integer**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html) |       |           |
|          | tab separated                                                                                      |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | create **\<Item\>ArrayDriver** class                                                               | 1     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | declared **\<item\>Arr**                                                                           | 1     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | main method:                                                                                       | 1     |           |
|          | [**File**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/io/File.html) object  |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | main method:                                                                                       | 1     |           |
|          | [**Scanner**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Scanner.html) |       |           |
|          | object                                                                                             |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | Loop to read text file with                                                                        | 2     |           |
|          | [**Scanner**](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Scanner.html) |       |           |
|          | methods next() and nextInt()                                                                       |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | Instantiate \<Item\> and add to \<item\>Arr                                                        | 2     |           |
+----------+----------------------------------------------------------------------------------------------------+-------+-----------+
| Part 3:  | **public int overallAvg( \<Item\>\[\] a )**                                                        | 2     |           |
| Methods  |                                                                                                    |       |           |
| to       |                                                                                                    |       |           |
| process  |                                                                                                    |       |           |
| \<Item\> |                                                                                                    |       |           |
| array    |                                                                                                    |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public int count( \<Item\>\[\] a, \<Item\> o )**                                                 | 2     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public int groupAvg(\<Item\>\[\] a, String s)**                                                  | 2     |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public \<Item\>\[\] lessThan( \<Item\>\[\] a,                                                    | 2     |           |
|          | [Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html) i   |       |           |
|          | )**                                                                                                |       |           |
|          +----------------------------------------------------------------------------------------------------+-------+-----------+
|          | **public void groupEdit( \<Item\>\[\] a,                                                           | 2     |           |
|          | [String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html) s,    |       |           |
|          | [Integer](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Integer.html) n   |       |           |
|          | )**                                                                                                |       |           |
+----------+----------------------------------------------------------------------------------------------------+-------+-----------+
| TOTAL    |                                                                                                    | 35    |           |
+----------+----------------------------------------------------------------------------------------------------+-------+-----------+

# Submission Instructions

- Using your IDE (Eclipse, Visual Studio, IntelliJ, etc), create a java
  project and call it **\<yourLastName\>Assignment1**.

- Create .java files and a text file to implement the classes as
  described above.

- Archive the three files into [one zip file]{.underline}.

- Upload [only one .zip file]{.underline} to the D2L folder called
  Assignment 1.

- [It is important that you upload your code in only one zip file. Your
  assignment will not be graded if you upload individual files to the
  drop box**.**]{.underline}

- You may submit more than once, but only the last submission (that is,
  the single .zip file with the most recent timestamp) will be graded.

# Example

Just to clarify, suppose that I wanted my \<Item\> to be the forbidden
Pet item. I might want the String to be a name and the Integer to be an
age in years. Then I would have a **Pet** class in a file Pet.java. It
would have attributes such as

**String name;**

**Integer age;**

Somehow, in a comment or variable name, I would have to make clear that
age is in years.

My input text file could have entries like this:

Fido 12

Garfield 17

Sylvester 9

Snoopy 8

Nemo 2

...

etc.

The driver class would be called **PetArrayDriver**, and it would
contain an array **Pet\[\] petArray**

[^1]: Note: In the next assignment, you will divide this Item into two
    subclasses of items. So pick an Item that can be divided easily. For
    instance, to use a prohibited example, Pet might be subdivided into
    Dog and Cat. It will be OK if not all Items belong to one of the
    subclasses. (Maybe you have a bird named "Polly".) Additionally, you
    will be asked to add an Integer instance variable to one of the
    subclasses and a Boolean instance variable to the other. So plan
    ahead.
