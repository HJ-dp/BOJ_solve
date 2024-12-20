-- 코드를 입력하세요
# SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
# FROM FOOD_PRODUCT
# ORDER BY PRICE DESC
# LIMIT 1

WITH MP AS (
    SELECT MAX(PRICE) as MPRICE
    FROM FOOD_PRODUCT
)

SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM FOOD_PRODUCT n
INNER JOIN MP m 
ON n.PRICE = m.MPRICE
LIMIT 1