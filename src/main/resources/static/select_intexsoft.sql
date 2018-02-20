--all users
select *
from webapp.USERS;

--users with 'admin' ROLE
select FULLNAME as admin
from webapp.USERS
where ROLE = 'admin';

-- urls having length of symbols more 10
SELECT URL as "URL>10"
FROM webapp.LINKS
GROUP BY URL
HAVING length(URL) > 10;

--users who shorten links
SELECT u.FULLNAME, ull.URL AS URL
FROM webapp.USERS u
JOIN (
       SELECT ul.USER_ID, l.URL
       FROM webapp.USERS_LINKS ul
       JOIN webapp.LINKS l
          ON ul.LINK_ID = l.LINK_ID
     ) ull
        ON u.USER_ID = ull.USER_ID;

--USER_ID containing in both tables: 'users' and 'users_links'
SELECT USER_ID AS id
FROM webapp.USERS
UNION ALL
  SELECT USER_ID
  FROM webapp.USERS_LINKS;

--tags which begin with 'i' letter
SELECT TITLE AS tag
FROM webapp.TAGS
WHERE TITLE LIKE 'i%'
ORDER BY TITLE DESC ;

-- short URL with tags in depending tags TITLE natural order
SELECT l.SHORT_URL, ltt.TITLE
FROM webapp.LINKS l
  JOIN (
      SELECT lt.LINK_ID, t.TITLE
      FROM webapp.LINKS_TAGS lt
      JOIN webapp.TAGS t
        ON lt.TAG_ID = t.TAG_ID
    ) ltt
    ON l.LINK_ID = ltt.LINK_ID
WHERE SHORT_URL LIKE 'http%'
      AND length(TITLE) > 3
ORDER BY TITLE;

-- LINK_ID with length of strings concatenating from tags titles binding with this link
SELECT lt.LINK_ID AS id, sum(length(t.TITLE)) AS string_length
FROM webapp.LINKS_TAGS lt
JOIN webapp.TAGS t
  ON lt.TAG_ID = t.TAG_ID
GROUP BY lt.LINK_ID
ORDER BY string_length;