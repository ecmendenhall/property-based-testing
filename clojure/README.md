# Clojure

## Dependencies
- [Leiningen](http://leiningen.org/)

## Property-based testing framework
- [clojure/test.check](https://github.com/clojure/test.check)

## Setup
From the `prime-factors` directory, run:

```
$ lein deps
```

## Run unit tests

From the `prime-factors` directory, run:

```
$ lein test prime-factors.core-test
```

## Run property-based tests

From the `prime-factors` directory, run:

```
$ lein test prime-factors.core-check
```
