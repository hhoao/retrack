### ArrayList.stream()分析:

1. 调用StreamSupport.stream()方法

```java
default Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
}
```

2. 我们先看spliterator()方法，这里通过创建一个ArrayListSpliterator()对象，我们来看看这个对象有什么用

```java
@Override
public Spliterator<E> spliterator() {
    return new ArrayListSpliterator(0, -1, 0);
}
```



3. ArrayListSpliterator类是ArrayList的内部类，它实现了Spliterator，而Spliterator有什么用呢,我们来看源码介绍（翻译）:

    > ​	如果数组列表是不可变的，或者在结构上是不可变的(没有添加、删除等)，我们可以使用Arrays.spliterator实现它们的spliterator。相反，我们在遍历过程中检测到尽可能多的干扰，而不牺牲太多的性能。我们主要依靠modCounts。这些方法不能保证检测到并发冲突，而且有时对于线程内干扰过于保守，但是在实践中检测到足够多的问题是值得的。为了实现这一点，我们（1）延迟初始化fence和expectedModCount，直到我们需要提交到我们检查的状态的最新点;从而提高精度。(这并不适用于sublist，它使用当前的非延迟值创建拆分器)。
    >
    > （2）我们只在forEach(性能最敏感的方法)的末尾执行一个ConcurrentModificationException检查。使用forEach(与迭代器相反)时，通常只能检测动作之后的干扰，而不能检测动作之前的干扰。进一步的cme触发检查适用于所有其他可能违反假设的情况，例如null或太小的elementData数组(给定其size())，这只能由于干扰而发生。这允许forEach的内部循环无需任何进一步的检查就可以运行，并简化了lambda解析。虽然这需要进行大量的检查，但请注意，在list.stream().forEach(a)的常见情况下，除了在forEach内部之外，任何地方都不会发生检查或其他计算。其他不太常用的方法不能充分利用这些流线型。

    可以得出该类是延迟加载的迭代器

```java
final class ArrayListSpliterator implements Spliterator<E> {
     ArrayListSpliterator(int origin, int fence, int expectedModCount) {
            this.index = origin; //当前的索引
            this.fence = fence;	//索引前的一个数吧
            this.expectedModCount = expectedModCount; // initialized when fence set
        }
}
```

4. 我们再来看刚开始分析时的StreamSupport.stream(spliterator(), false)方法

    从Spliterator创建一个新的顺序或并行流。

    spliterator只在流管道的终端操作开始后被遍历、分割或查询估计的大小。

```java
public static <T> Stream<T> stream(Spliterator<T> spliterator, boolean parallel) {
    Objects.requireNonNull(spliterator);
    return new ReferencePipeline.Head<>(spliterator,
                                        StreamOpFlag.fromCharacteristics(spliterator),
                                        parallel);
}
```

5. 解析Head，

    Head继承了ReferencePipeline

    ```java
    static class Head&lt;E_IN, E_OUT&gt; extends ReferencePipeline&lt;E_IN, E_OUT&gt; {
    }
    ```

6. 解析ReferencePipeline

    ReferencePipeline就是一个Stream

    ```java
    abstract class ReferencePipeline<P_IN, P_OUT>
            extends AbstractPipeline<P_IN, P_OUT, Stream<P_OUT>>
            implements Stream<P_OUT>  {
    }
    ```

    

### Stream方法分析

| `boolean`                      | `allMatch(Predicate<? super T> predicate)`  返回此流中的所有元素是否匹配所提供的谓词。 |
| :----------------------------- | ------------------------------------------------------------ |
| `boolean`                      | `anyMatch(Predicate<? super T> predicate)`  返回此流中的任何元素是否匹配所提供的谓词。 |
| `static <T> Stream.Builder<T>` | `builder()`  返回一个 `Stream`生成器。                       |
| `<R,A> R`                      | `collect(Collector<? super T,A,R> collector)`  执行 [mutable reduction](package-summary.html#MutableReduction)操作对元素的使用  `Collector`流。 |
| `<R> R`                        | `collect(Supplier<R> supplier,  BiConsumer<R,? super  T> accumulator, BiConsumer<R,R> combiner)`  执行该流的元素 [mutable reduction](package-summary.html#MutableReduction)操作。 |
| `static <T> Stream<T>`         | `concat(Stream<? extends T> a, Stream<? extends  T> b)`  创建一个懒洋洋的级联流的元素的所有元素的第一流通过第二个流的元素。 |
| `long`                         | `count()`  返回此流中元素的计数。                            |
| `Stream<T>`                    | `distinct()`  返回一个包含不同的元素流（根据 [`Object.equals(Object)`](../../../java/lang/Object.html#equals-java.lang.Object-)）这个流。 |
| `static <T> Stream<T>`         | `empty()`  返回一个空的顺序 `Stream`。                       |
| `Stream<T>`                    | `filter(Predicate<? super T> predicate)`  返回由该流的元素组成的流，该元素与给定的谓词匹配。 |
| `Optional<T>`                  | `findAny()`  返回一个 [`Optional`](../../../java/util/Optional.html)描述一些流元素，或一个空的  `Optional`如果流是空的。 |
| `Optional<T>`                  | `findFirst()`  返回一个 [`Optional`](../../../java/util/Optional.html)描述此流的第一个元素，或者一个空的  `Optional`如果流是空的。 |
| `<R> Stream<R>`                | `flatMap(Function<? super T,? extends Stream<? extends  R>> mapper)`  返回由将所提供的映射函数应用到每个元素的映射流的内容替换此流的每个元素的结果的结果流。 |
| `DoubleStream`                 | `flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)`  返回一个包含有一个映射的流应用提供的映射功能，每个元件产生的内容替换此流的每个元素的结果  `DoubleStream`。 |
| `IntStream`                    | `flatMapToInt(Function<? super T,? extends IntStream> mapper)`  返回一个包含有一个映射的流应用提供的映射功能，每个元件产生的内容替换此流的每个元素的结果  `IntStream`。 |
| `LongStream`                   | `flatMapToLong(Function<? super T,? extends LongStream> mapper)`  返回一个包含有一个映射的流应用提供的映射功能，每个元件产生的内容替换此流的每个元素的结果  `LongStream`。 |
| `void`                         | `forEach(Consumer<? super T> action)`  对该流的每个元素执行一个动作。 |
| `void`                         | `forEachOrdered(Consumer<? super T> action)`  对该流的每个元素执行一个操作，如果流有一个定义的遇到顺序，则在该流的遇到顺序中执行一个动作。 |
| `static <T> Stream<T>`         | `generate(Supplier<T> s)`  返回一个无穷序列无序流，其中每个元素是由提供 `Supplier`生成。 |
| `static <T> Stream<T>`         | `iterate(T seed,  UnaryOperator<T> f)`  返回一个无穷序列有序 `Stream`由最初的一元  `seed`函数的 `f`迭代应用产生的，产生一个由 `seed`，  `f(seed)`， `f(f(seed))` `Stream`，等。 |
| `Stream<T>`                    | `limit(long maxSize)`  返回一个包含该流的元素流，截断长度不超过 `maxSize`。 |
| `<R> Stream<R>`                | `map(Function<? super T,? extends  R> mapper)`  返回一个流，包括将给定函数应用到该流元素的结果。 |
| `DoubleStream`                 | `mapToDouble(ToDoubleFunction<?  super T> mapper)`  返回一个包含应用给定的功能，该流的元素的结果  `DoubleStream`。 |
| `IntStream`                    | `mapToInt(ToIntFunction<?  super T> mapper)`  返回一个包含应用给定的功能，该流的元素的结果 `IntStream`。 |
| `LongStream`                   | `mapToLong(ToLongFunction<?  super T> mapper)`  返回一个包含应用给定的功能，该流的元素的结果 `LongStream`。 |
| `Optional<T>`                  | `max(Comparator<? super T> comparator)`  返回最大元本流根据提供的 `Comparator`。 |
| `Optional<T>`                  | `min(Comparator<? super T> comparator)`  返回最小元本流根据提供的 `Comparator`。 |
| `boolean`                      | `noneMatch(Predicate<? super T> predicate)`  返回此流中的任何元素是否匹配所提供的谓词。 |
| `static <T> Stream<T>`         | `of(T... values)`  返回一个元素为指定值的顺序排列的流。      |
| `static <T> Stream<T>`         | `of(T t)`  返回一个包含一个元素的顺序 `Stream`。             |
| `Stream<T>`                    | `peek(Consumer<? super T> action)`  返回由该流的元素组成的流，并在所提供的流中执行所提供的每个元素上的动作。 |
| `Optional<T>`                  | `reduce(BinaryOperator<T> accumulator)`  对这一 [reduction](package-summary.html#Reduction)流元素，使用 [associative](package-summary.html#Associativity)累积函数，并返回一个  `Optional`描述价值减少，如果任何。 |
| `T`                            | `reduce(T identity, BinaryOperator<T> accumulator)`  对这一 [reduction](package-summary.html#Reduction)流元素，使用提供的价值认同和 [associative](package-summary.html#Associativity)累积函数，返回值减少。 |
| `<U> U`                        | `reduce(U identity,  BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)`  对这一 [reduction](package-summary.html#Reduction)流元素，使用提供的身份，积累和组合功能。 |
| `Stream<T>`                    | `skip(long n)`  返回一个包含此流的其余部分丢弃的流的第一 `n`元素后流。 |
| `Stream<T>`                    | `sorted()`  返回由该流的元素组成的流，按自然顺序排序。       |
| `Stream<T>`                    | `sorted(Comparator<? super T> comparator)`  返回一个包含该流的元素流，根据提供的 `Comparator`排序。 |
| `Object[]`                     | `toArray()`  返回包含此流元素的数组。                        |
| `<A> A[]`                      | `toArray(IntFunction<A[]> generator)`  返回一个数组包含该流的元素，使用提供的  `generator`函数分配的返回的数组，以及可能对分区执行或调整所需的任何额外的数组。 |