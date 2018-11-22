# ping
A Portable Network Graphics (PING) Library

##Overview
**ping** is a lightweight and extensible library for working at the chunk level of a Portable Network 
Graphics formatted image.

##Specification
The [PNG (Portable Network Graphics) Specification, Version 1.2](http://www.libpng.org/pub/png/spec/1.2/PNG-Contents.html), 
was used as the basis for this lightweight and extensible library.   


## Naming Conventions
In weighing de facto Java naming conventions versus clarity of the type of PNG chunk being manipulated, I selected
to follow the PNG standards and name various chunk files verbatim. In other words, the class that maps the PNG 
International textual data, iTXt, has a Java class name that aligns with the the PNG specification, 
i.e. _iTXtChunk.java_.


