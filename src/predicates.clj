(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn has-award-pred [book]
  (fn [award] (has-award? book award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (has-award-pred book) awards))

(defn my-some [pred a-seq]
  (let [accepted (filter pred a-seq)
        values (map pred accepted)]
    (first values)))

(defn my-every? [pred a-seq]
  (let [accepted (filter pred a-seq)]
    (= (count accepted) (count a-seq))))

(defn prime? [n]
  (let [divisible-by (fn [x] (= (mod n x) 0))]
    (not (some divisible-by (range 2 n)))))
;^^
