(ns cars-assemble)


(def production-base-rate 221)
(def minute-per-hour 60)
(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (double (cond (= speed 0) 0
                (<= speed 4) (* speed production-base-rate)
                (<= speed 8) (* 0.90 (* speed production-base-rate))
                (= speed 9) (* 0.80 (* speed production-base-rate))
                (= speed 10) (* 0.77 (* speed production-base-rate)))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) (float minute-per-hour))))
