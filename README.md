# Sigma Library

## Probability Formulas

1. **Basic Probability** ✅
    - `P(A) = Number of favorable outcomes / Total number of outcomes`

2. **Complement Rule** ✅
    - `P(A') = 1 - P(A)`

3. **Conditional Probability** ✅
    - `P(A|B) = P(A ∩ B) / P(B)`

4. **Bayes' Theorem** ✅
    - `P(A|B) = [P(B|A) * P(A)] / P(B)`

5. **Addition Rule (for Non-Mutually Exclusive Events)** ✅
    - `P(A ∪ B) = P(A) + P(B) - P(A ∩ B)`

6. **Multiplication Rule (for Independent Events)** ✅
    - `P(A ∩ B) = P(A) * P(B)`

7. **Law of Total Probability**
    - `P(A) = Σ [P(A|Bi) * P(Bi)]`

8. **Bayes' Theorem (General Form)**
    - `P(A|B) = [P(B|A) * P(A)] / Σ [P(B|Ai) * P(Ai)]`

9. **Probability Mass Function (PMF)**
    - `P(X = x) = f(x)`

10. **Probability Density Function (PDF)**
    - `f(x) = dF(x) / dx`

11. **Cumulative Distribution Function (CDF)**
    - `F(x) = P(X ≤ x)`

12. **Joint Probability**
    - `P(A ∩ B) = P(A) * P(B|A)`

13. **Marginal Probability**
    - `P(A) = Σ P(A, B)`

14. **Expectation (Expected Value)**
    - `E[X] = Σ x * P(X = x)`

15. **Variance**
    - `Var(X) = E[(X - E[X])²]`

16. **Covariance**
    - `Cov(X, Y) = E[(X - E[X]) * (Y - E[Y])]`

17. **Correlation Coefficient**
    - `ρ(X, Y) = Cov(X, Y) / (σX * σY)`

18. **Moment Generating Function (MGF)**
    - `M(t) = E[e^(tX)]`

19. **Characteristic Function**
    - `φ(t) = E[e^(itX)]`

20. **Law of Large Numbers**
    - `As n → ∞, X̄ → μ`

## Statistics Formulas

1. **Mean (Arithmetic Average)**
    - `Mean = Σx / N`

2. **Median**
    - `Middle value in a sorted list`

3. **Mode**
    - `Most frequent value`

4. **Variance**
    - `Variance (σ²) = Σ(xi - Mean)² / N`

5. **Standard Deviation**
    - `Standard Deviation (σ) = √Variance`

6. **Z-Score**
    - `Z = (X - Mean) / Standard Deviation`

7. **Coefficient of Variation**
    - `CV = (Standard Deviation / Mean) * 100%`

8. **Skewness**
    - `γ1 = (Σ(xi - Mean)³ / N) / σ³`

9. **Kurtosis**
    - `γ2 = (Σ(xi - Mean)⁴ / N) / σ⁴ - 3`

10. **Pearson Correlation Coefficient**
    - `r = Σ[(xi - Mean_x) * (yi - Mean_y)] / (N * σ_x * σ_y)`

11. **Spearman's Rank Correlation Coefficient**
    - `ρ = 1 - [6 * Σd² / (n * (n² - 1))]`

12. **Simple Linear Regression**
    - `Y = a + bX`

13. **Least Squares Estimator**
    - `b = Σ[(xi - Mean_x) * (yi - Mean_y)] / Σ(xi - Mean_x)²`

14. **Regression Coefficients**
    - `a = Mean_y - b * Mean_x`

15. **Confidence Interval for Mean (Normal Distribution)**
    - `CI = Mean ± (Z * (σ/√n))`

16. **Confidence Interval for Proportion**
    - `CI = p ± Z * √(p(1-p)/n)`

17. **T-Statistic**
    - `t = (Mean - μ) / (s/√n)`

18. **Chi-Square Test Statistic**
    - `χ² = Σ[(O_i - E_i)² / E_i]`

19. **F-Statistic**
    - `F = (S²_between / df_between) / (S²_within / df_within)`

20. **ANOVA F-Statistic**
    - `F = Variance_between / Variance_within`
