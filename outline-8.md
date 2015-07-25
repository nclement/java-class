## String methods

Strings in Java are different from other basic types -- they are "objects."

In part that means that Strings are associated with a set of methods that can be
called on them.

Use the dot notation: ``<variable>.<method>()``

    String s = "hello";
    System.out.println(s);
    System.out.println(s.toUppercase());
    System.out.println(s.substring(2, 4));
    System.out.println(s.length());
    System.out.println(s.endsWith("lo"));
    System.out.println(s.endsWith("ll"));
    System.out.println(s.contains("ll"));
    System.out.println(s.contains("LL"));

## Memory

We've already seen how a variable is a name for a piece of memory. But what does
that mean?

In Java, a variable names a piece of memory that's as big as the memory
architecture of the machine. For example, on a 64-bit Java Virtual Machine, each
``double``, ``int``, ``boolean``, etc. is a name for 64 bits (8 Bytes) of
memory.

### Scope

Each variable in a Java program has a limited visibility.

### Pointers

But what about more complex data types, like ``String``? A ``String`` can
contain 1, or 10, or 100, or 100000 characters. How would these all fit into 8
Bytes of memory?

The answer is that a variable of type ``String`` is a name for 8 Bytes of
memory. However, the contents of that variable are an 8-Byte integer that is the
address of another place in memory!

