/**
 * Concurrency Control we can do by synchronizing the methods or blocks of code.
 * It will work when distributed system there.
 * synchronize good for single having multiple threads.But in distributed system many process are running.
 *
 * for Distributed transactions : - optimistic concurrency control and pessimistic concurrency control
 *
 * 1.Transactions
 *  BEGIN_TRANSACTION
 *    Debit money from account A
 *    Credit money to account B
 *    if all success
 *    THEN
 *      COMMIT
 *    ELSE
 *      ROLLBACK
 *   END_TRANSACTION
 *
 * 2.DB locking
 *  no other transaction can not access the locked rows
 *  1.shared lock - read
 *  2.exclusive lock - no read and no write
 *
 *
 * 3.Isolation levels
 *  Dirty Read - read uncommitted data
 *  Non-Repeatable Read - read committed data     query 10 > and query < 15
 *  Phantom Read - repeatable read data and getting different data that not need
 *
 * isolation levels        Dirty Read   | Non-Repeatable Read | Phantom Read
 * Read Uncommitted        |     Yes    |         Yes         |      Yes             consistency high
 * Read Committed          |     No     |         Yes         |      Yes                  ^
 * Repeatable Read         |     No     |         No          |      Yes                  |
 * Serializable            |     No     |         No          |      No               consistency low
 *
 * Isolation levels        Locking strategy
 *
 * Read uncommitted        |  No locks for read and write
 * Read committed          |  Read : shared lock required and Release as soon as read is done and Write : exclusive lock required and keep till end transaction
 * Repeatable read         |  Shared lock for read and exclusive lock for write
 * Serializable            |  Shared lock for read and exclusive lock for write
 *
 *
 *
 *
 * concurrent database operations
 * prevent concurrent updates unless the data is unchanged.
 * optimistic and pessimistic --> expected frequency of data conflicts and the need for data consistency versus system performance.
 */


package com.example;