## Learn Custom Annotation

### Package (Annotation)
- For create custom annotation, we will create annotation interface
`public @interface PrintHello ` then we need to add 3 annotation in this
1. `@Target(ElementType.METHOD)` = where to apply this annotation
2. `@Retention(RetentionPolicy.RUNTIME)` = when to execute this annotation runtime or compile time
3. `@Documented` = it will generate document when this annotation is implemented in other service that import this annotation (like library)
- For class `PrintHelloAspect` it is AOP programming that mean we can implement some logic of code like logging or helper in this custom annotation
instead for to reduce redundant code in business logic code
- `@Aspect` = This means it contains advice (code that runs before, after, or around methods).
- `@Around("@annotation(printHello)")` This tells Spring to execute this advice (method) around any method annotated with @PrintHello.
  The @annotation(printHello) part means it looks for a custom annotation named @PrintHello