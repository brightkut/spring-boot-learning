## Learn Concurrency

- We implement function `doConcurrencyProcess` for a concurrency process
using `CompletableFuture`(Parallelism) with `supplyAsync` function. And we need to add
- We use `join()` to block current thread until `CompletableFuture` done 
- We use `CompletableFuture.allOf(...)` to group the concurrency process
- We is able to ignore `@Async` if we use custom `Executor`
- We create custom task `Executor` (configure thread pool) in class `AsyncConfig`
