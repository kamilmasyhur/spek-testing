Spek Testing

What happened here? I just trying to know how Spek working, and how its flow on running test,
I tried to print all of the result and I found something ugly about it
I don't know if it's my bad because I don't know how Spek running, but the result is bad to use it
along with bigger office production code.

What's wrong with it?

you can clone this project and see the result
is it the same as mine?

```
first line spek
first line inside feature
first line inside scenario A
last line inside scenario A
first line inside scenario B
last line inside scenario B
last line inside feature
last line in spek


before each test outside feature
before each test inside feature
before each step A
other value inside memoized
another value inside memoized
given A
real value
lazy value
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step A
when A
real value
lazy value
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step A
then A
real value
lazy value
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature

after scenario A
after each group A
after each scenario inside feature
after each group outside feature
before each group outside feature
before each scenario inside feature
before each group B
before scenario B


before each test outside feature
before each test inside feature
before each step B
other value inside memoized
another value inside memoized
given B
[other value]
[another value]
after each step B
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step B
when B
[other value]
[another value]
after each step B
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step B
then B
[other value]
[another value]
after each step B
after each test inside feature
after each test outside feature

after scenario B
after each group B
after each scenario inside feature
after each group outside feature
after each scenario inside feature
after feature inside feature
after each group outside feature
after each group outside feature
after group outside feature


before group outside feature
before each group outside feature
before each group outside feature
before feature inside feature
before each scenario inside feature
before each group outside feature
before each scenario inside feature
before each group A
before scenario A
```

What's wrong?
========

# First

```
first line spek
first line inside feature
first line inside scenario A
last line inside scenario A
first line inside scenario B
last line inside scenario B
last line inside feature
last line in spek
```

What's wrong here is spek  calling last line before they even run the test.

# Second

```
before group outside feature
before each group outside feature
before each group outside feature
before feature inside feature
before each scenario inside feature
before each group outside feature
before each scenario inside feature
before each group A
before scenario A
```

What is wrong here its last printed line, its showing that Spek call `before group`, `before each group`, `before feature`, `before scenario` it very late
and then spek call `before each group` twice

# Third

Spek will throw an Exception:
```
junit.framework.AssertionFailedError:
```
because the memoized value outside feature is not initialized yet.

to try it, uncomment everything commented on the test

```
before each test outside feature
before each test inside feature
before each step A
value inside memoized
other value inside memoized
another value inside memoized
given A
real value
lazy value
[value]
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step A
when A
real value
lazy value
value inside memoized
[]
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature


before each test outside feature
before each test inside feature
before each step A
then A
real value
lazy value
value inside memoized
[]
[other value]
[another value]
after each step A
after each test inside feature
after each test outside feature
```

Inside given, the value is initialized, but after that, in when, the value is empty, in then part, value is still empty, I don't know what happened here
