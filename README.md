# minimal-cljs-spec-problem

This demonstrates a problem with clojure.spec in ClojureScript 1.9.456 and 1.9.473.

The problem is that you might get an exception similar to the following under certain conditions when calling `cljs.spec/valid?`:

```
Uncaught Error: No protocol method ICounted.-count defined for type cljs.core/Keyword: :cljs.spec/invalid
    at Object.cljs$core$missing_protocol [as missing_protocol] (core.cljs:281)
    at Object.cljs$core$_count [as _count] (core.cljs:485)
    at cljs$core$count (core.cljs:1729)
    at minimal_cljs_spec_problem$core$pred_2_QMARK_ (core.cljc:14)
    at cljs.spec.spec_impl.cljs$core$IFn$_invoke$arity$5.cljs.spec.t_cljs$spec9667.cljs$spec$Spec$conform_STAR_$arity$2 (spec.cljs:474)
    at cljs$spec$conform_STAR_ (spec.cljs:40)
    at spec.cljs:725
    at cljs.spec.and_spec_impl.cljs.spec.t_cljs$spec9824.cljs$spec$Spec$conform_STAR_$arity$2 (spec.cljs:737)
    at cljs$spec$conform_STAR_ (spec.cljs:40)
    at Function.cljs.spec.valid_QMARK_.cljs$core$IFn$_invoke$arity$2 (spec.cljs:357)
```

This happens when using `cljs.spec/and` with several predicates where an early predicate is unsatisfied and following predicates depend on earlier ones being satisfied.

The problem appears in both of:

* ClojureScript 1.9.456.
* ClojureScript 1.9.473.

It does not appear in any of:

* ClojureScript 1.9.293.
* Clojure 1.9.0-alpha14.

Workaround:

Make sure the subsequent predicates don't throw even when earlier predicates are unsatisfied.

## Usage

1. `lein cljsbuild once dev`
1. Serve the resource directory with an HTTP server, for example webfs.
1. Load `test.html` in a web browser.
1. Check the browser console.

## License

Copyright © 2017 Henrik Lundahl

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
