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
 * Read Uncommitted        |     Yes    |         Yes         |      Yes             consistency high                use only when only reads                   optimistic concurrency control
 * Read Committed          |     No     |         Yes         |      Yes                  ^                                                                     optimistic concurrency control
 * Repeatable Read         |     No     |         No          |      Yes                  |                                                                    pessimistic concurrency control
 * Serializable            |     No     |         No          |      No               consistency low                                                           pessimistic concurrency control
 *
 * Isolation levels        Locking strategy
 *
 * Read uncommitted        |  No locks for read and write
 * Read committed          |  Read : shared lock required and Release as soon as read is done and Write : exclusive lock required and keep till end transaction
 * Repeatable read         |  Read : shared lock required and Release at end transaction and Write : exclusive lock required and release at end of transaction
 * Serializable            |  Same as Repeatable read locking strategy and apply range lock and lock is release at end of transaction
 *
 * In PostgresSQL, @Transactional--> the locking behavior of default--> Read Committed
 *
 * concurrent database operations
 * prevent concurrent updates unless the data is unchanged.
 * optimistic and pessimistic --> expected frequency of data conflicts and the need for data consistency versus system performance.
 *
 *  optimistic concurrency control OCC -->
 *   1.Isolation Level used Below Repeatable Read
 *   2.Higher concurrency
 *   3.No chance Deadlock
 *   4.In case of conflict, rollback the transaction and retry logic is there
 *
 *   pessimistic concurrency control PCC-->
 *   1.Isolation Level used Repeatable Read and Serializable
 *   2.Lower concurrency
 *   3.Chance of Deadlock and need force rollback
 *   4.Putting long lock,sometimes timeout issue comes and need to be done
 *
 *
 *  in PCC --> either tx1 or tx2 completed and other waited but problem is deadlock
 *
 *
 *
 *
 */


package com.example;