package com.devotion.rws.wapper;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.BatchUpdateException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * SQL查询包装器
 */
public class PreparedStatementWrapper implements PreparedStatement {

    /**
     * 用于执行SQL查询的API
     */
    private PreparedStatement currentPreparedStatement;

    /**
     * 构造方法
     *
     * @param currentPreparedStatement 当前currentPreparedStatement
     */
    public PreparedStatementWrapper(PreparedStatement currentPreparedStatement) {
        super();
        this.currentPreparedStatement = currentPreparedStatement;
    }

    /**
     * Executes the given SQL statement, which returns a single
     * <code>ResultSet</code> object.
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql an SQL statement to be sent to the database, typically a
     *            static SQL <code>SELECT</code> statement
     * @return a <code>ResultSet</code> object that contains the data produced
     * by the given query; never <code>null</code>
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the given SQL
     *                      statement produces anything other than a single
     *                      <code>ResultSet</code> object, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     */
    public ResultSet executeQuery(String sql) throws SQLException {
        return currentPreparedStatement.executeQuery(sql);
    }

    /**
     * Executes the given SQL statement, which may be an <code>INSERT</code>,
     * <code>UPDATE</code>, or <code>DELETE</code> statement or an SQL statement
     * that returns nothing, such as an SQL DDL statement.
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql an SQL Data Manipulation Language (DML) statement, such as
     *            <code>INSERT</code>, <code>UPDATE</code> or
     *            <code>DELETE</code>; or an SQL statement that returns nothing,
     *            such as a DDL statement.
     * @return either (1) the row count for SQL Data Manipulation Language (DML)
     * statements or (2) 0 for SQL statements that return nothing
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the given SQL
     *                      statement produces a <code>ResultSet</code> object, the
     *                      method is called on a <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     */
    public int executeUpdate(String sql) throws SQLException {
        return currentPreparedStatement.executeUpdate(sql);
    }

    /**
     * Releases this <code>Statement</code> object's database and JDBC resources
     * immediately instead of waiting for this to happen when it is
     * automatically closed. It is generally good practice to release resources
     * as soon as you are finished with them to avoid tying up database
     * resources.
     * <p>
     * Calling the method <code>close</code> on a <code>Statement</code> object
     * that is already closed has no effect.
     * <p>
     * <B>Note:</B>When a <code>Statement</code> object is closed, its current
     * <code>ResultSet</code> object, if one exists, is also closed.
     *
     * @throws SQLException if a database access error occurs
     */
    public void close() throws SQLException {
        currentPreparedStatement.close();
    }

    /**
     * Retrieves the maximum number of bytes that can be returned for character
     * and binary column values in a <code>ResultSet</code> object produced by
     * this <code>Statement</code> object. This limit applies only to
     * <code>BINARY</code>, <code>VARBINARY</code>, <code>LONGVARBINARY</code>,
     * <code>CHAR</code>, <code>VARCHAR</code>, <code>NCHAR</code>,
     * <code>NVARCHAR</code>, <code>LONGNVARCHAR</code> and
     * <code>LONGVARCHAR</code> columns. If the limit is exceeded, the excess
     * data is silently discarded.
     *
     * @return the current column size limit for columns storing character and
     * binary values; zero means there is no limit
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setMaxFieldSize
     */
    public int getMaxFieldSize() throws SQLException {
        return currentPreparedStatement.getMaxFieldSize();
    }

    /**
     * Sets the limit for the maximum number of bytes that can be returned for
     * character and binary column values in a <code>ResultSet</code> object
     * produced by this <code>Statement</code> object.
     * <p>
     * This limit applies only to <code>BINARY</code>, <code>VARBINARY</code>,
     * <code>LONGVARBINARY</code>, <code>CHAR</code>, <code>VARCHAR</code>,
     * <code>NCHAR</code>, <code>NVARCHAR</code>, <code>LONGNVARCHAR</code> and
     * <code>LONGVARCHAR</code> fields. If the limit is exceeded, the excess
     * data is silently discarded. For maximum portability, use values greater
     * than 256.
     *
     * @param max the new column size limit in bytes; zero means there is no
     *            limit
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code> or the condition max >=
     *                      0 is not satisfied
     * @see #getMaxFieldSize
     */
    public void setMaxFieldSize(int max) throws SQLException {
        currentPreparedStatement.setMaxFieldSize(max);
    }

    /**
     * Retrieves the maximum number of rows that a <code>ResultSet</code> object
     * produced by this <code>Statement</code> object can contain. If this limit
     * is exceeded, the excess rows are silently dropped.
     *
     * @return the current maximum number of rows for a <code>ResultSet</code>
     * object produced by this <code>Statement</code> object; zero means
     * there is no limit
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setMaxRows
     */
    public int getMaxRows() throws SQLException {
        return currentPreparedStatement.getMaxRows();
    }

    /**
     * Retrieves the maximum number of rows that a <code>ResultSet</code> object
     * produced by this <code>Statement</code> object can contain. If this limit
     * is exceeded, the excess rows are silently dropped.
     *
     * @param max max
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setMaxRows
     */
    public void setMaxRows(int max) throws SQLException {
        currentPreparedStatement.setMaxRows(max);
    }

    /**
     * Sets escape processing on or off. If escape scanning is on (the default),
     * the driver will do escape substitution before sending the SQL statement
     * to the database.
     * <p>
     * Note: Since prepared statements have usually been parsed prior to making
     * this call, disabling escape processing for
     * <code>PreparedStatements</code> objects will have no effect.
     *
     * @param enable <code>true</code> to enable escape processing;
     *               <code>false</code> to disable it
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     */
    public void setEscapeProcessing(boolean enable) throws SQLException {
        currentPreparedStatement.setEscapeProcessing(enable);
    }

    /**
     * Retrieves the number of seconds the driver will wait for a
     * <code>Statement</code> object to execute. If the limit is exceeded, a
     * <code>SQLException</code> is thrown.
     *
     * @return the current query timeout limit in seconds; zero means there is
     * no limit
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setQueryTimeout
     */
    public int getQueryTimeout() throws SQLException {
        return currentPreparedStatement.getQueryTimeout();
    }

    /**
     * Retrieves the number of seconds the driver will wait for a
     * <code>Statement</code> object to execute. If the limit is exceeded, a
     * <code>SQLException</code> is thrown.
     *
     * @param seconds seconds
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setQueryTimeout
     */
    public void setQueryTimeout(int seconds) throws SQLException {
        currentPreparedStatement.getQueryTimeout();
    }

    /**
     * Cancels this <code>Statement</code> object if both the DBMS and driver
     * support aborting an SQL statement. This method can be used by one thread
     * to cancel a statement that is being executed by another thread.
     *
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     */
    public void cancel() throws SQLException {
        currentPreparedStatement.cancel();
    }

    /**
     * Retrieves the first warning reported by calls on this
     * <code>Statement</code> object. Subsequent <code>Statement</code> object
     * warnings will be chained to this <code>SQLWarning</code> object.
     * <p>
     * <p>
     * The warning chain is automatically cleared each time a statement is
     * (re)executed. This method may not be called on a closed
     * <code>Statement</code> object; doing so will cause an
     * <code>SQLException</code> to be thrown.
     * <p>
     * <p>
     * <B>Note:</B> If you are processing a <code>ResultSet</code> object, any
     * warnings associated with reads on that <code>ResultSet</code> object will
     * be chained on it rather than on the <code>Statement</code> object that
     * produced it.
     *
     * @return the first <code>SQLWarning</code> object or <code>null</code> if
     * there are no warnings
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     */
    public SQLWarning getWarnings() throws SQLException {
        return currentPreparedStatement.getWarnings();
    }

    /**
     * Clears all the warnings reported on this <code>Statement</code> object.
     * After a call to this method, the method <code>getWarnings</code> will
     * return <code>null</code> until a new warning is reported for this
     * <code>Statement</code> object.
     *
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     */
    public void clearWarnings() throws SQLException {
        currentPreparedStatement.clearWarnings();
    }

    /**
     * Sets the SQL cursor name to the given <code>String</code>, which will be
     * used by subsequent <code>Statement</code> object <code>execute</code>
     * methods. This name can then be used in SQL positioned update or delete
     * statements to identify the current row in the <code>ResultSet</code>
     * object generated by this statement. If the database does not support
     * positioned update/delete, this method is a noop. To insure that a cursor
     * has the proper isolation level to support updates, the cursor's
     * <code>SELECT</code> statement should have the form
     * <code>SELECT FOR UPDATE</code>. If <code>FOR UPDATE</code> is not
     * present, positioned updates may fail.
     * <p>
     * <p>
     * <B>Note:</B> By definition, the execution of positioned updates and
     * deletes must be done by a different <code>Statement</code> object than
     * the one that generated the <code>ResultSet</code> object being used for
     * positioning. Also, cursor names must be unique within a connection.
     *
     * @param name the new cursor name, which must be unique within a connection
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     */
    public void setCursorName(String name) throws SQLException {
        currentPreparedStatement.setCursorName(name);
    }

    /**
     * Executes the given SQL statement, which may return multiple results. In
     * some (uncommon) situations, a single SQL statement may return multiple
     * result sets and/or update counts. Normally you can ignore this unless you
     * are (1) executing a stored procedure that you know may return multiple
     * results or (2) you are dynamically executing an unknown SQL string.
     * <p>
     * The <code>execute</code> method executes an SQL statement and indicates
     * the form of the first result. You must then use the methods
     * <code>getResultSet</code> or <code>getUpdateCount</code> to retrieve the
     * result, and <code>getMoreResults</code> to move to any subsequent
     * result(s).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql any SQL statement
     * @return <code>true</code> if the first result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no results
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the method is called
     *                      on a <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     */
    public boolean execute(String sql) throws SQLException {
        return currentPreparedStatement.execute(sql);
    }

    /**
     * Retrieves the current result as a <code>ResultSet</code> object. This
     * method should be called only once per result.
     *
     * @return the current result as a <code>ResultSet</code> object or
     * <code>null</code> if the result is an update count or there are
     * no more results
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #execute
     */
    public ResultSet getResultSet() throws SQLException {
        return currentPreparedStatement.getResultSet();
    }

    /**
     * Retrieves the current result as an update count; if the result is a
     * <code>ResultSet</code> object or there are no more results, -1 is
     * returned. This method should be called only once per result.
     *
     * @return the current result as an update count; -1 if the current result
     * is a <code>ResultSet</code> object or there are no more results
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #execute
     */
    public int getUpdateCount() throws SQLException {
        return currentPreparedStatement.getUpdateCount();
    }

    /**
     * Moves to this <code>Statement</code> object's next result, returns
     * <code>true</code> if it is a <code>ResultSet</code> object, and
     * implicitly closes any current <code>ResultSet</code> object(s) obtained
     * with the method <code>getResultSet</code>.
     * <p>
     * <p>
     * There are no more results when the following is true:
     * <p>
     * <PRE>
     * // stmt is a Statement object
     * ((stmt.getMoreResults() == false) &amp;&amp; (stmt.getUpdateCount() == -1))
     * </PRE>
     *
     * @return <code>true</code> if the next result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no more results
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #execute
     */
    public boolean getMoreResults() throws SQLException {
        return currentPreparedStatement.getMoreResults();
    }

    /**
     * Gives the driver a hint as to the direction in which rows will be
     * processed in <code>ResultSet</code> objects created using this
     * <code>Statement</code> object. The default value is
     * <code>ResultSet.FETCH_FORWARD</code>.
     * <p>
     * Note that this method sets the default fetch direction for result sets
     * generated by this <code>Statement</code> object. Each result set has its
     * own methods for getting and setting its own fetch direction.
     *
     * @param direction the initial direction for processing rows
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code> or the given direction
     *                      is not one of <code>ResultSet.FETCH_FORWARD</code>,
     *                      <code>ResultSet.FETCH_REVERSE</code>, or
     *                      <code>ResultSet.FETCH_UNKNOWN</code>
     * @see #getFetchDirection
     * @since 1.2
     */
    public void setFetchDirection(int direction) throws SQLException {
        currentPreparedStatement.setFetchDirection(direction);
    }

    /**
     * Retrieves the direction for fetching rows from database tables that is
     * the default for result sets generated from this <code>Statement</code>
     * object. If this <code>Statement</code> object has not set a fetch
     * direction by calling the method <code>setFetchDirection</code>, the
     * return value is implementation-specific.
     *
     * @return the default fetch direction for result sets generated from this
     * <code>Statement</code> object
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setFetchDirection
     * @since 1.2
     */
    public int getFetchDirection() throws SQLException {
        return currentPreparedStatement.getFetchDirection();
    }

    /**
     * Gives the JDBC driver a hint as to the number of rows that should be
     * fetched from the database when more rows are needed for
     * <code>ResultSet</code> objects genrated by this <code>Statement</code>.
     * If the value specified is zero, then the hint is ignored. The default
     * value is zero.
     *
     * @param rows the number of rows to fetch
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code> or the condition
     *                      <code>rows >= 0</code> is not satisfied.
     * @see #getFetchSize
     * @since 1.2
     */
    public void setFetchSize(int rows) throws SQLException {
        currentPreparedStatement.setFetchSize(rows);
    }

    /**
     * Retrieves the number of result set rows that is the default fetch size
     * for <code>ResultSet</code> objects generated from this
     * <code>Statement</code> object. If this <code>Statement</code> object has
     * not set a fetch size by calling the method <code>setFetchSize</code>, the
     * return value is implementation-specific.
     *
     * @return the default fetch size for result sets generated from this
     * <code>Statement</code> object
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #setFetchSize
     * @since 1.2
     */
    public int getFetchSize() throws SQLException {
        return currentPreparedStatement.getFetchSize();
    }

    /**
     * Retrieves the result set concurrency for <code>ResultSet</code> objects
     * generated by this <code>Statement</code> object.
     *
     * @return either <code>ResultSet.CONCUR_READ_ONLY</code> or
     * <code>ResultSet.CONCUR_UPDATABLE</code>
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @since 1.2
     */
    public int getResultSetConcurrency() throws SQLException {
        return currentPreparedStatement.getResultSetConcurrency();
    }

    /**
     * Retrieves the result set type for <code>ResultSet</code> objects
     * generated by this <code>Statement</code> object.
     *
     * @return one of <code>ResultSet.TYPE_FORWARD_ONLY</code>,
     * <code>ResultSet.TYPE_SCROLL_INSENSITIVE</code>, or
     * <code>ResultSet.TYPE_SCROLL_SENSITIVE</code>
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @since 1.2
     */
    public int getResultSetType() throws SQLException {
        return currentPreparedStatement.getResultSetType();
    }

    /**
     * Adds the given SQL command to the current list of commmands for this
     * <code>Statement</code> object. The commands in this list can be executed
     * as a batch by calling the method <code>executeBatch</code>.
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql typically this is a SQL <code>INSERT</code> or
     *            <code>UPDATE</code> statement
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the driver does not
     *                      support batch updates, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @see #executeBatch
     * @see DatabaseMetaData#supportsBatchUpdates
     * @since 1.2
     */
    public void addBatch(String sql) throws SQLException {
        currentPreparedStatement.addBatch(sql);
    }

    /**
     * Empties this <code>Statement</code> object's current list of SQL
     * commands.
     * <p>
     *
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code> or the driver does not
     *                      support batch updates
     * @see #addBatch
     * @see DatabaseMetaData#supportsBatchUpdates
     * @since 1.2
     */
    public void clearBatch() throws SQLException {
        currentPreparedStatement.clearBatch();
    }

    /**
     * Submits a batch of commands to the database for execution and if all
     * commands execute successfully, returns an array of update counts. The
     * <code>int</code> elements of the array that is returned are ordered to
     * correspond to the commands in the batch, which are ordered according to
     * the order in which they were added to the batch. The elements in the
     * array returned by the method <code>executeBatch</code> may be one of the
     * following:
     * <OL>
     * <LI>A number greater than or equal to zero -- indicates that the command
     * was processed successfully and is an update count giving the number of
     * rows in the database that were affected by the command's execution
     * <LI>A value of <code>SUCCESS_NO_INFO</code> -- indicates that the command
     * was processed successfully but that the number of rows affected is
     * unknown
     * <p>
     * If one of the commands in a batch update fails to execute properly, this
     * method throws a <code>BatchUpdateException</code>, and a JDBC driver may
     * or may not continue to process the remaining commands in the batch.
     * However, the driver's behavior must be consistent with a particular DBMS,
     * either always continuing to process commands or never continuing to
     * process commands. If the driver continues processing after a failure, the
     * array returned by the method
     * <code>BatchUpdateException.getUpdateCounts</code> will contain as many
     * elements as there are commands in the batch, and at least one of the
     * elements will be the following:
     * <p>
     * <LI>A value of <code>EXECUTE_FAILED</code> -- indicates that the command
     * failed to execute successfully and occurs only if a driver continues to
     * process commands after a command fails
     * </OL>
     * <p>
     * The possible implementations and return values have been modified in the
     * Java 2 SDK, Standard Edition, version 1.3 to accommodate the option of
     * continuing to proccess commands in a batch update after a
     * <code>BatchUpdateException</code> obejct has been thrown.
     *
     * @return an array of update counts containing one element for each command
     * in the batch. The elements of the array are ordered according to
     * the order in which commands were added to the batch.
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code> or the driver does not
     *                      support batch statements. Throws
     *                      {@link BatchUpdateException} (a subclass of
     *                      <code>SQLException</code>) if one of the commands sent to
     *                      the database fails to execute properly or attempts to
     *                      return a result set.
     * @see #addBatch
     * @see DatabaseMetaData#supportsBatchUpdates
     * @since 1.2
     */
    public int[] executeBatch() throws SQLException {
        return currentPreparedStatement.executeBatch();
    }

    /**
     * Retrieves the <code>Connection</code> object that produced this
     * <code>Statement</code> object.
     *
     * @return the connection that produced this statement
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @since 1.2
     */
    public Connection getConnection() throws SQLException {
        return new ConnectionWrapper(currentPreparedStatement.getConnection());
    }

    /**
     * Moves to this <code>Statement</code> object's next result, returns
     * <code>true</code> if it is a <code>ResultSet</code> object, and
     * implicitly closes any current <code>ResultSet</code> object(s) obtained
     * with the method <code>getResultSet</code>.
     * <p>
     * <p>
     * There are no more results when the following is true:
     * <p>
     * <PRE>
     * // stmt is a Statement object
     * ((stmt.getMoreResults() == false) &amp;&amp; (stmt.getUpdateCount() == -1))
     * </PRE>
     *
     * @param current current
     * @return <code>true</code> if the next result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no more results
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @see #execute
     */
    public boolean getMoreResults(int current) throws SQLException {
        return currentPreparedStatement.getMoreResults();
    }

    /**
     * Retrieves any auto-generated keys created as a result of executing this
     * <code>Statement</code> object. If this <code>Statement</code> object did
     * not generate any keys, an empty <code>ResultSet</code> object is
     * returned.
     * <p>
     * <p>
     * <B>Note:</B>If the columns which represent the auto-generated keys were
     * not specified, the JDBC driver implementation will determine the columns
     * which best represent the auto-generated keys.
     *
     * @return a <code>ResultSet</code> object containing the auto-generated
     * key(s) generated by the execution of this <code>Statement</code>
     * object
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @since 1.4
     */
    public ResultSet getGeneratedKeys() throws SQLException {
        return currentPreparedStatement.getGeneratedKeys();
    }

    /**
     * Executes the SQL statement in this <code>PreparedStatement</code> object,
     * which must be an SQL Data Manipulation Language (DML) statement, such as
     * <code>INSERT</code>, <code>UPDATE</code> or <code>DELETE</code>; or an
     * SQL statement that returns nothing, such as a DDL statement.
     *
     * @param sql               sql
     * @param autoGeneratedKeys autoGeneratedKeys
     * @return either (1) the row count for SQL Data Manipulation Language (DML)
     * statements or (2) 0 for SQL statements that return nothing
     * @throws SQLException if a database access error occurs; this method is called
     *                      on a closed <code>PreparedStatement</code> or the SQL
     *                      statement returns a <code>ResultSet</code> object
     */
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return currentPreparedStatement.executeUpdate();
    }

    /**
     * Executes the given SQL statement and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval. This array contains the indexes of the columns in the
     * target table that contain the auto-generated keys that should be made
     * available. The driver will ignore the array if the SQL statement is not
     * an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql           an SQL Data Manipulation Language (DML) statement, such as
     *                      <code>INSERT</code>, <code>UPDATE</code> or
     *                      <code>DELETE</code>; or an SQL statement that returns nothing,
     *                      such as a DDL statement.
     * @param columnIndexes an array of column indexes indicating the columns that should
     *                      be returned from the inserted row
     * @return either (1) the row count for SQL Data Manipulation Language (DML)
     * statements or (2) 0 for SQL statements that return nothing
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the SQL statement
     *                      returns a <code>ResultSet</code> object,the second
     *                      argument supplied to this method is not an
     *                      <code>int</code> array whose elements are valid column
     *                      indexes, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @since 1.4
     */
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return currentPreparedStatement.executeUpdate(sql, columnIndexes);
    }

    /**
     * Executes the given SQL statement and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval. This array contains the names of the columns in the target
     * table that contain the auto-generated keys that should be made available.
     * The driver will ignore the array if the SQL statement is not an
     * <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql         an SQL Data Manipulation Language (DML) statement, such as
     *                    <code>INSERT</code>, <code>UPDATE</code> or
     *                    <code>DELETE</code>; or an SQL statement that returns nothing,
     *                    such as a DDL statement.
     * @param columnNames an array of the names of the columns that should be returned
     *                    from the inserted row
     * @return either the row count for <code>INSERT</code>, <code>UPDATE</code>
     * , or <code>DELETE</code> statements, or 0 for SQL statements that
     * return nothing
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the SQL statement
     *                      returns a <code>ResultSet</code> object, the second
     *                      argument supplied to this method is not a
     *                      <code>String</code> array whose elements are valid column
     *                      names, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @since 1.4
     */
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        return currentPreparedStatement.executeUpdate(sql, columnNames);
    }

    /**
     * Executes the given SQL statement, which may return multiple results, and
     * signals the driver that any auto-generated keys should be made available
     * for retrieval. The driver will ignore this signal if the SQL statement is
     * not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <p>
     * In some (uncommon) situations, a single SQL statement may return multiple
     * result sets and/or update counts. Normally you can ignore this unless you
     * are (1) executing a stored procedure that you know may return multiple
     * results or (2) you are dynamically executing an unknown SQL string.
     * <p>
     * The <code>execute</code> method executes an SQL statement and indicates
     * the form of the first result. You must then use the methods
     * <code>getResultSet</code> or <code>getUpdateCount</code> to retrieve the
     * result, and <code>getMoreResults</code> to move to any subsequent
     * result(s).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql               any SQL statement
     * @param autoGeneratedKeys a constant indicating whether auto-generated keys should be
     *                          made available for retrieval using the method
     *                          <code>getGeneratedKeys</code>; one of the following constants:
     *                          <code>Statement.RETURN_GENERATED_KEYS</code> or
     *                          <code>Statement.NO_GENERATED_KEYS</code>
     * @return <code>true</code> if the first result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no results
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the second parameter
     *                      supplied to this method is not
     *                      <code>Statement.RETURN_GENERATED_KEYS</code> or
     *                      <code>Statement.NO_GENERATED_KEYS</code>, the method is
     *                      called on a <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     * @see #getGeneratedKeys
     * @since 1.4
     */
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return currentPreparedStatement.execute(sql, autoGeneratedKeys);
    }

    /**
     * Executes the given SQL statement, which may return multiple results, and
     * signals the driver that the auto-generated keys indicated in the given
     * array should be made available for retrieval. This array contains the
     * indexes of the columns in the target table that contain the
     * auto-generated keys that should be made available. The driver will ignore
     * the array if the SQL statement is not an <code>INSERT</code> statement,
     * or an SQL statement able to return auto-generated keys (the list of such
     * statements is vendor-specific).
     * <p>
     * Under some (uncommon) situations, a single SQL statement may return
     * multiple result sets and/or update counts. Normally you can ignore this
     * unless you are (1) executing a stored procedure that you know may return
     * multiple results or (2) you are dynamically executing an unknown SQL
     * string.
     * <p>
     * The <code>execute</code> method executes an SQL statement and indicates
     * the form of the first result. You must then use the methods
     * <code>getResultSet</code> or <code>getUpdateCount</code> to retrieve the
     * result, and <code>getMoreResults</code> to move to any subsequent
     * result(s).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql           any SQL statement
     * @param columnIndexes an array of the indexes of the columns in the inserted row
     *                      that should be made available for retrieval by a call to the
     *                      method <code>getGeneratedKeys</code>
     * @return <code>true</code> if the first result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no results
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>, the elements in the
     *                      <code>int</code> array passed to this method are not valid
     *                      column indexes, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     * @since 1.4
     */
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return currentPreparedStatement.execute(sql, columnIndexes);
    }

    /**
     * Executes the given SQL statement, which may return multiple results, and
     * signals the driver that the auto-generated keys indicated in the given
     * array should be made available for retrieval. This array contains the
     * names of the columns in the target table that contain the auto-generated
     * keys that should be made available. The driver will ignore the array if
     * the SQL statement is not an <code>INSERT</code> statement, or an SQL
     * statement able to return auto-generated keys (the list of such statements
     * is vendor-specific).
     * <p>
     * In some (uncommon) situations, a single SQL statement may return multiple
     * result sets and/or update counts. Normally you can ignore this unless you
     * are (1) executing a stored procedure that you know may return multiple
     * results or (2) you are dynamically executing an unknown SQL string.
     * <p>
     * The <code>execute</code> method executes an SQL statement and indicates
     * the form of the first result. You must then use the methods
     * <code>getResultSet</code> or <code>getUpdateCount</code> to retrieve the
     * result, and <code>getMoreResults</code> to move to any subsequent
     * result(s).
     * <p>
     * <strong>Note:</strong>This method cannot be called on a
     * <code>PreparedStatement</code> or <code>CallableStatement</code>.
     *
     * @param sql         any SQL statement
     * @param columnNames an array of the names of the columns in the inserted row that
     *                    should be made available for retrieval by a call to the method
     *                    <code>getGeneratedKeys</code>
     * @return <code>true</code> if the next result is a <code>ResultSet</code>
     * object; <code>false</code> if it is an update count or there are
     * no more results
     * @throws SQLException if a database access error occurs, this method is called
     *                      on a closed <code>Statement</code>,the elements of the
     *                      <code>String</code> array passed to this method are not
     *                      valid column names, the method is called on a
     *                      <code>PreparedStatement</code> or
     *                      <code>CallableStatement</code>
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     * @see #getGeneratedKeys
     * @since 1.4
     */
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return currentPreparedStatement.execute(sql, columnNames);
    }

    /**
     * Retrieves the result set holdability for <code>ResultSet</code> objects
     * generated by this <code>Statement</code> object.
     *
     * @return either <code>ResultSet.HOLD_CURSORS_OVER_COMMIT</code> or
     * <code>ResultSet.CLOSE_CURSORS_AT_COMMIT</code>
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>Statement</code>
     * @since 1.4
     */
    public int getResultSetHoldability() throws SQLException {
        return currentPreparedStatement.getResultSetHoldability();
    }

    /**
     * Retrieves whether this <code>Statement</code> object has been closed. A
     * <code>Statement</code> is closed if the method close has been called on
     * it, or if it is automatically closed.
     *
     * @return true if this <code>Statement</code> object is closed; false if it
     * is still open
     * @throws SQLException if a database access error occurs
     * @since 1.6
     */
    public boolean isClosed() throws SQLException {
        return currentPreparedStatement.isClosed();
    }

    /**
     * Requests that a <code>Statement</code> be pooled or not pooled. The value
     * specified is a hint to the statement pool implementation indicating
     * whether the applicaiton wants the statement to be pooled. It is up to the
     * statement pool manager as to whether the hint is used.
     * <p>
     * The poolable value of a statement is applicable to both internal
     * statement caches implemented by the driver and external statement caches
     * implemented by application servers and other applications.
     * <p>
     * By default, a <code>Statement</code> is not poolable when created, and a
     * <code>PreparedStatement</code> and <code>CallableStatement</code> are
     * poolable when created.
     * <p>
     *
     * @param poolable requests that the statement be pooled if true and that the
     *                 statement not be pooled if false
     *                 <p>
     * @throws SQLException if this method is called on a closed <code>Statement</code>
     *                      <p>
     * @since 1.6
     */
    public void setPoolable(boolean poolable) throws SQLException {
        currentPreparedStatement.setPoolable(poolable);
    }

    /**
     * Returns a value indicating whether the <code>Statement</code> is poolable
     * or not.
     * <p>
     *
     * @return <code>true</code> if the <code>Statement</code> is poolable;
     * <code>false</code> otherwise
     * <p>
     * @throws SQLException if this method is called on a closed <code>Statement</code>
     *                      <p>
     * @see java.sql.Statement#setPoolable(boolean) setPoolable(boolean)
     * @since 1.6
     * <p>
     */
    public boolean isPoolable() throws SQLException {
        return currentPreparedStatement.isPoolable();
    }

    /**
     * Returns an object that implements the given interface to allow access to
     * non-standard methods, or standard methods not exposed by the proxy.
     * <p>
     * If the receiver implements the interface then the result is the receiver
     * or a proxy for the receiver. If the receiver is a wrapper and the wrapped
     * object implements the interface then the result is the wrapped object or
     * a proxy for the wrapped object. Otherwise return the the result of
     * calling <code>unwrap</code> recursively on the wrapped object or a proxy
     * for that result. If the receiver is not a wrapper and does not implement
     * the interface, then an <code>SQLException</code> is thrown.
     *
     * @param iface A Class defining an interface that the result must implement.
     * @param <T>   泛型对象
     * @return an object that implements the interface. May be a proxy for the
     * actual implementing object.
     * @throws SQLException If no object found that implements the interface
     * @since 1.6
     */
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return currentPreparedStatement.unwrap(iface);
    }

    /**
     * Returns true if this either implements the interface argument or is
     * directly or indirectly a wrapper for an object that does. Returns false
     * otherwise. If this implements the interface then return true, else if
     * this is a wrapper then return the result of recursively calling
     * <code>isWrapperFor</code> on the wrapped object. If this does not
     * implement the interface and is not a wrapper, return false. This method
     * should be implemented as a low-cost operation compared to
     * <code>unwrap</code> so that callers can use this method to avoid
     * expensive <code>unwrap</code> calls that may fail. If this method returns
     * true then calling <code>unwrap</code> with the same argument should
     * succeed.
     *
     * @param iface a Class defining an interface.
     * @return true if this implements the interface or directly or indirectly
     * wraps an object that does.
     * @throws SQLException if an error occurs while determining whether this is a
     *                      wrapper for an object with the given interface.
     * @since 1.6
     */
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return currentPreparedStatement.isWrapperFor(iface);
    }

    /**
     * Executes the SQL query in this <code>PreparedStatement</code> object and
     * returns the <code>ResultSet</code> object generated by the query.
     *
     * @return a <code>ResultSet</code> object that contains the data produced
     * by the query; never <code>null</code>
     * @throws SQLException if a database access error occurs; this method is called
     *                      on a closed <code>PreparedStatement</code> or the SQL
     *                      statement does not return a <code>ResultSet</code> object
     */
    public ResultSet executeQuery() throws SQLException {
        return currentPreparedStatement.executeQuery();
    }

    /**
     * Executes the SQL statement in this <code>PreparedStatement</code> object,
     * which must be an SQL Data Manipulation Language (DML) statement, such as
     * <code>INSERT</code>, <code>UPDATE</code> or <code>DELETE</code>; or an
     * SQL statement that returns nothing, such as a DDL statement.
     *
     * @return either (1) the row count for SQL Data Manipulation Language (DML)
     * statements or (2) 0 for SQL statements that return nothing
     * @throws SQLException if a database access error occurs; this method is called
     *                      on a closed <code>PreparedStatement</code> or the SQL
     *                      statement returns a <code>ResultSet</code> object
     */
    public int executeUpdate() throws SQLException {
        return currentPreparedStatement.executeUpdate();
    }

    /**
     * Sets the designated parameter to SQL <code>NULL</code>.
     * <p>
     * <p>
     * <B>Note:</B> You must specify the parameter's SQL type.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param sqlType        the SQL type code defined in <code>java.sql.Types</code>
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        currentPreparedStatement.setNull(parameterIndex, sqlType);
    }

    /**
     * Sets the designated parameter to the given Java <code>boolean</code>
     * value. The driver converts this to an SQL <code>BIT</code> or
     * <code>BOOLEAN</code> value when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        currentPreparedStatement.setBoolean(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given Java <code>byte</code> value.
     * The driver converts this to an SQL <code>TINYINT</code> value when it
     * sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setByte(int parameterIndex, byte x) throws SQLException {
        currentPreparedStatement.setByte(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given Java <code>short</code> value.
     * The driver converts this to an SQL <code>SMALLINT</code> value when it
     * sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setShort(int parameterIndex, short x) throws SQLException {
        currentPreparedStatement.setShort(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given Java <code>int</code> value.
     * The driver converts this to an SQL <code>INTEGER</code> value when it
     * sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setInt(int parameterIndex, int x) throws SQLException {
        currentPreparedStatement.setInt(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given Java <code>long</code> value.
     * The driver converts this to an SQL <code>BIGINT</code> value when it
     * sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setLong(int parameterIndex, long x) throws SQLException {
        currentPreparedStatement.setLong(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given Java <code>float</code> value.
     * The driver converts this to an SQL <code>REAL</code> value when it sends
     * it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setFloat(int parameterIndex, float x) throws SQLException {
        currentPreparedStatement.setFloat(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given Java <code>double</code>
     * value. The driver converts this to an SQL <code>DOUBLE</code> value when
     * it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setDouble(int parameterIndex, double x) throws SQLException {
        currentPreparedStatement.setDouble(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given
     * <code>java.math.BigDecimal</code> value. The driver converts this to an
     * SQL <code>NUMERIC</code> value when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        currentPreparedStatement.setBigDecimal(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given Java <code>String</code>
     * value. The driver converts this to an SQL <code>VARCHAR</code> or
     * <code>LONGVARCHAR</code> value (depending on the argument's size relative
     * to the driver's limits on <code>VARCHAR</code> values) when it sends it
     * to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setString(int parameterIndex, String x) throws SQLException {
        currentPreparedStatement.setString(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given Java array of bytes. The
     * driver converts this to an SQL <code>VARBINARY</code> or
     * <code>LONGVARBINARY</code> (depending on the argument's size relative to
     * the driver's limits on <code>VARBINARY</code> values) when it sends it to
     * the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        currentPreparedStatement.setBytes(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Date</code>
     * value using the default time zone of the virtual machine that is running
     * the application. The driver converts this to an SQL <code>DATE</code>
     * value when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setDate(int parameterIndex, Date x) throws SQLException {
        currentPreparedStatement.setDate(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Time</code>
     * value. The driver converts this to an SQL <code>TIME</code> value when it
     * sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setTime(int parameterIndex, Time x) throws SQLException {
        currentPreparedStatement.setTime(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given
     * <code>java.sql.Timestamp</code> value. The driver converts this to an SQL
     * <code>TIMESTAMP</code> value when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        currentPreparedStatement.setTimestamp(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given input stream, which will have
     * the specified number of bytes. When a very large ASCII value is input to
     * a <code>LONGVARCHAR</code> parameter, it may be more practical to send it
     * via a <code>java.io.InputStream</code>. Data will be read from the stream
     * as needed until end-of-file is reached. The JDBC driver will do any
     * necessary conversion from ASCII to the database char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the Java input stream that contains the ASCII parameter value
     * @param length         the number of bytes in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        currentPreparedStatement.setAsciiStream(parameterIndex, x, length);

    }

    /**
     * Sets the designated parameter to the given input stream, which will have
     * the specified number of bytes.
     * <p>
     * When a very large Unicode value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.InputStream</code> object. The data will be read from the
     * stream as needed until end-of-file is reached. The JDBC driver will do
     * any necessary conversion from Unicode to the database char format.
     * <p>
     * The byte format of the Unicode stream must be a Java UTF-8, as defined in
     * the Java Virtual Machine Specification.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              a <code>java.io.InputStream</code> object that contains the
     *                       Unicode parameter value
     * @param length         the number of bytes in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @deprecated
     */
    @Deprecated
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        currentPreparedStatement.setUnicodeStream(parameterIndex, x, length);
    }

    /**
     * Sets the designated parameter to the given input stream, which will have
     * the specified number of bytes. When a very large binary value is input to
     * a <code>LONGVARBINARY</code> parameter, it may be more practical to send
     * it via a <code>java.io.InputStream</code> object. The data will be read
     * from the stream as needed until end-of-file is reached.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the java input stream which contains the binary parameter
     *                       value
     * @param length         the number of bytes in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     */
    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        currentPreparedStatement.setBinaryStream(parameterIndex, x, length);
    }

    /**
     * Clears the current parameter values immediately.
     * <p>
     * In general, parameter values remain in force for repeated use of a
     * statement. Setting a parameter value automatically clears its previous
     * value. However, in some cases it is useful to immediately release the
     * resources used by the current parameter values; this can be done by
     * calling the method <code>clearParameters</code>.
     *
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>PreparedStatement</code>
     */
    public void clearParameters() throws SQLException {
        currentPreparedStatement.clearParameters();
    }

    /**
     * Sets the value of the designated parameter with the given object. This
     * method is like the method <code>setObject</code> above, except that it
     * assumes a scale of zero.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the object containing the input parameter value
     * @param targetSqlType  the SQL type (as defined in java.sql.Types) to be sent to the
     *                       database
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @see java.sql.Types
     */
    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        currentPreparedStatement.setObject(parameterIndex, x, targetSqlType);
    }

    /**
     * <p>
     * Sets the value of the designated parameter using the given object. The
     * second parameter must be of type <code>Object</code>; therefore, the
     * <code>java.lang</code> equivalent objects should be used for built-in
     * types.
     * <p>
     * <p>
     * The JDBC specification specifies a standard mapping from Java
     * <code>Object</code> types to SQL types. The given argument will be
     * converted to the corresponding SQL type before being sent to the
     * database.
     * <p>
     * <p>
     * Note that this method may be used to pass datatabase- specific abstract
     * data types, by using a driver-specific Java type.
     * <p>
     * If the object is of a class implementing the interface
     * <code>SQLData</code>, the JDBC driver should call the method
     * <code>SQLData.writeSQL</code> to write it to the SQL data stream. If, on
     * the other hand, the object is of a class implementing <code>Ref</code>,
     * <code>Blob</code>, <code>Clob</code>, <code>NClob</code>,
     * <code>Struct</code>, <code>java.net.URL</code>, <code>RowId</code>,
     * <code>SQLXML</code> or <code>Array</code>, the driver should pass it to
     * the database as a value of the corresponding SQL type.
     * <p>
     * <b>Note:</b> Not all databases allow for a non-typed Null to be sent to
     * the backend. For maximum portability, the <code>setNull</code> or the
     * <code>setObject(int parameterIndex, Object x, int sqlType)</code> method
     * should be used instead of
     * <code>setObject(int parameterIndex, Object x)</code>.
     * <p>
     * <b>Note:</b> This method throws an exception if there is an ambiguity,
     * for example, if the object is of a class implementing more than one of
     * the interfaces named above.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the object containing the input parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs; this method is called on a closed
     *                      <code>PreparedStatement</code> or the type of the given
     *                      object is ambiguous
     */
    public void setObject(int parameterIndex, Object x) throws SQLException {
        currentPreparedStatement.setObject(parameterIndex, x);
    }

    /**
     * Executes the SQL statement in this <code>PreparedStatement</code> object,
     * which may be any kind of SQL statement. Some prepared statements return
     * multiple results; the <code>execute</code> method handles these complex
     * statements as well as the simpler form of statements handled by the
     * methods <code>executeQuery</code> and <code>executeUpdate</code>.
     * <p>
     * The <code>execute</code> method returns a <code>boolean</code> to
     * indicate the form of the first result. You must call either the method
     * <code>getResultSet</code> or <code>getUpdateCount</code> to retrieve the
     * result; you must call <code>getMoreResults</code> to move to any
     * subsequent result(s).
     *
     * @return <code>true</code> if the first result is a <code>ResultSet</code>
     * object; <code>false</code> if the first result is an update count
     * or there is no result
     * @throws SQLException if a database access error occurs; this method is called
     *                      on a closed <code>PreparedStatement</code> or an argument
     *                      is supplied to this method
     * @see java.sql.Statement#execute
     * @see java.sql.Statement#getResultSet
     * @see java.sql.Statement#getUpdateCount
     * @see java.sql.Statement#getMoreResults
     */
    public boolean execute() throws SQLException {
        return currentPreparedStatement.execute();
    }

    /**
     * Adds a set of parameters to this <code>PreparedStatement</code> object's
     * batch of commands.
     *
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>PreparedStatement</code>
     * @see java.sql.Statement#addBatch
     * @since 1.2
     */
    public void addBatch() throws SQLException {
        currentPreparedStatement.addBatch();
    }

    /**
     * Sets the designated parameter to the given <code>Reader</code> object,
     * which is the given number of characters long. When a very large UNICODE
     * value is input to a <code>LONGVARCHAR</code> parameter, it may be more
     * practical to send it via a <code>java.io.Reader</code> object. The data
     * will be read from the stream as needed until end-of-file is reached. The
     * JDBC driver will do any necessary conversion from UNICODE to the database
     * char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param reader         the <code>java.io.Reader</code> object that contains the
     *                       Unicode data
     * @param length         the number of characters in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        currentPreparedStatement.setCharacterStream(parameterIndex, reader, length);
    }

    /**
     * Sets the designated parameter to the given
     * <code>REF(&lt;structured-type&gt;)</code> value. The driver converts this
     * to an SQL <code>REF</code> value when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              an SQL <code>REF</code> value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        currentPreparedStatement.setRef(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Blob</code>
     * object. The driver converts this to an SQL <code>BLOB</code> value when
     * it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              a <code>Blob</code> object that maps an SQL <code>BLOB</code>
     *                       value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        currentPreparedStatement.setBlob(parameterIndex, x);
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Clob</code>
     * object. The driver converts this to an SQL <code>CLOB</code> value when
     * it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              a <code>Clob</code> object that maps an SQL <code>CLOB</code>
     *                       value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        currentPreparedStatement.setClob(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Array</code>
     * object. The driver converts this to an SQL <code>ARRAY</code> value when
     * it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              an <code>Array</code> object that maps an SQL
     *                       <code>ARRAY</code> value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setArray(int parameterIndex, Array x) throws SQLException {
        currentPreparedStatement.setArray(parameterIndex, x);

    }

    /**
     * Retrieves a <code>ResultSetMetaData</code> object that contains
     * information about the columns of the <code>ResultSet</code> object that
     * will be returned when this <code>PreparedStatement</code> object is
     * executed.
     * <p>
     * Because a <code>PreparedStatement</code> object is precompiled, it is
     * possible to know about the <code>ResultSet</code> object that it will
     * return without having to execute it. Consequently, it is possible to
     * invoke the method <code>getMetaData</code> on a
     * <code>PreparedStatement</code> object rather than waiting to execute it
     * and then invoking the <code>ResultSet.getMetaData</code> method on the
     * <code>ResultSet</code> object that is returned.
     * <p>
     * <B>NOTE:</B> Using this method may be expensive for some drivers due to
     * the lack of underlying DBMS support.
     *
     * @return the description of a <code>ResultSet</code> object's columns or
     * <code>null</code> if the driver cannot return a
     * <code>ResultSetMetaData</code> object
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>PreparedStatement</code>
     * @since 1.2
     */
    public ResultSetMetaData getMetaData() throws SQLException {
        return currentPreparedStatement.getMetaData();
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Date</code>
     * value, using the given <code>Calendar</code> object. The driver uses the
     * <code>Calendar</code> object to construct an SQL <code>DATE</code> value,
     * which the driver then sends to the database. With a <code>Calendar</code>
     * object, the driver can calculate the date taking into account a custom
     * timezone. If no <code>Calendar</code> object is specified, the driver
     * uses the default timezone, which is that of the virtual machine running
     * the application.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @param cal            the <code>Calendar</code> object the driver will use to
     *                       construct the date
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        currentPreparedStatement.setDate(parameterIndex, x, cal);
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.Time</code>
     * value, using the given <code>Calendar</code> object. The driver uses the
     * <code>Calendar</code> object to construct an SQL <code>TIME</code> value,
     * which the driver then sends to the database. With a <code>Calendar</code>
     * object, the driver can calculate the time taking into account a custom
     * timezone. If no <code>Calendar</code> object is specified, the driver
     * uses the default timezone, which is that of the virtual machine running
     * the application.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @param cal            the <code>Calendar</code> object the driver will use to
     *                       construct the time
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        currentPreparedStatement.setTime(parameterIndex, x, cal);

    }

    /**
     * Sets the designated parameter to the given
     * <code>java.sql.Timestamp</code> value, using the given
     * <code>Calendar</code> object. The driver uses the <code>Calendar</code>
     * object to construct an SQL <code>TIMESTAMP</code> value, which the driver
     * then sends to the database. With a <code>Calendar</code> object, the
     * driver can calculate the timestamp taking into account a custom timezone.
     * If no <code>Calendar</code> object is specified, the driver uses the
     * default timezone, which is that of the virtual machine running the
     * application.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @param cal            the <code>Calendar</code> object the driver will use to
     *                       construct the timestamp
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        currentPreparedStatement.setTimestamp(parameterIndex, x, cal);

    }

    /**
     * Sets the designated parameter to SQL <code>NULL</code>. This version of
     * the method <code>setNull</code> should be used for user-defined types and
     * REF type parameters. Examples of user-defined types include: STRUCT,
     * DISTINCT, JAVA_OBJECT, and named array types.
     * <p>
     * <p>
     * <B>Note:</B> To be portable, applications must give the SQL type code and
     * the fully-qualified SQL type name when specifying a NULL user-defined or
     * REF parameter. In the case of a user-defined type the name is the type
     * name of the parameter itself. For a REF parameter, the name is the type
     * name of the referenced type. If a JDBC driver does not need the type code
     * or type name information, it may ignore it.
     * <p>
     * Although it is intended for user-defined and Ref parameters, this method
     * may be used to set a null parameter of any JDBC type. If the parameter
     * does not have a user-defined or REF type, the given typeName is ignored.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param sqlType        a value from <code>java.sql.Types</code>
     * @param typeName       the fully-qualified name of an SQL user-defined type; ignored
     *                       if the parameter is not a user-defined type or REF
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.2
     */
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        currentPreparedStatement.setNull(parameterIndex, sqlType, typeName);

    }

    /**
     * Sets the designated parameter to the given <code>java.net.URL</code>
     * value. The driver converts this to an SQL <code>DATALINK</code> value
     * when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the <code>java.net.URL</code> object to be set
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.4
     */
    public void setURL(int parameterIndex, URL x) throws SQLException {
        currentPreparedStatement.setURL(parameterIndex, x);

    }

    /**
     * Retrieves the number, types and properties of this
     * <code>PreparedStatement</code> object's parameters.
     *
     * @return a <code>ParameterMetaData</code> object that contains information
     * about the number, types and properties for each parameter marker
     * of this <code>PreparedStatement</code> object
     * @throws SQLException if a database access error occurs or this method is called
     *                      on a closed <code>PreparedStatement</code>
     * @see ParameterMetaData
     * @since 1.4
     */
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return currentPreparedStatement.getParameterMetaData();
    }

    /**
     * Sets the designated parameter to the given <code>java.sql.RowId</code>
     * object. The driver converts this to a SQL <code>ROWID</code> value when
     * it sends it to the database
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs or
     *                      this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        currentPreparedStatement.setRowId(parameterIndex, x);
    }

    /**
     * Sets the designated paramter to the given <code>String</code> object. The
     * driver converts this to a SQL <code>NCHAR</code> or <code>NVARCHAR</code>
     * or <code>LONGNVARCHAR</code> value (depending on the argument's size
     * relative to the driver's limits on <code>NVARCHAR</code> values) when it
     * sends it to the database.
     *
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value          the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the driver does not support national
     *                      character sets; if the driver can detect that a data
     *                      conversion error could occur; if a database access error
     *                      occurs; or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNString(int parameterIndex, String value) throws SQLException {
        currentPreparedStatement.setNString(parameterIndex, value);

    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. The
     * <code>Reader</code> reads the data till end-of-file is reached. The
     * driver does the necessary conversion from Java character format to the
     * national character set in the database.
     *
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value          the parameter value
     * @param length         the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the driver does not support national
     *                      character sets; if the driver can detect that a data
     *                      conversion error could occur; if a database access error
     *                      occurs; or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        currentPreparedStatement.setNCharacterStream(parameterIndex, value, length);

    }

    /**
     * Sets the designated parameter to a <code>java.sql.NClob</code> object.
     * The driver converts this to a SQL <code>NCLOB</code> value when it sends
     * it to the database.
     *
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value          the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the driver does not support national
     *                      character sets; if the driver can detect that a data
     *                      conversion error could occur; if a database access error
     *                      occurs; or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        currentPreparedStatement.setNClob(parameterIndex, value);
    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. The reader
     * must contain the number of characters specified by length otherwise a
     * <code>SQLException</code> will be generated when the
     * <code>PreparedStatement</code> is executed. This method differs from the
     * <code>setCharacterStream (int, Reader, int)</code> method because it
     * informs the driver that the parameter value should be sent to the server
     * as a <code>CLOB</code>. When the <code>setCharacterStream</code> method
     * is used, the driver may have to do extra work to determine whether the
     * parameter data should be sent to the server as a <code>LONGVARCHAR</code>
     * or a <code>CLOB</code>
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader         An object that contains the data to set the parameter value
     *                       to.
     * @param length         the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs; this
     *                      method is called on a closed <code>PreparedStatement</code>
     *                      or if the length specified is less than zero.
     * @since 1.6
     */
    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        currentPreparedStatement.setClob(parameterIndex, reader, length);

    }

    /**
     * Sets the designated parameter to a <code>InputStream</code> object. The
     * inputstream must contain the number of characters specified by length
     * otherwise a <code>SQLException</code> will be generated when the
     * <code>PreparedStatement</code> is executed. This method differs from the
     * <code>setBinaryStream (int, InputStream, int)</code> method because it
     * informs the driver that the parameter value should be sent to the server
     * as a <code>BLOB</code>. When the <code>setBinaryStream</code> method is
     * used, the driver may have to do extra work to determine whether the
     * parameter data should be sent to the server as a
     * <code>LONGVARBINARY</code> or a <code>BLOB</code>
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param inputStream    An object that contains the data to set the parameter value
     *                       to.
     * @param length         the number of bytes in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs; this
     *                      method is called on a closed <code>PreparedStatement</code>;
     *                      if the length specified is less than zero or if the number of
     *                      bytes in the inputstream does not match the specfied length.
     * @since 1.6
     */
    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        currentPreparedStatement.setBlob(parameterIndex, inputStream, length);

    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. The reader
     * must contain the number of characters specified by length otherwise a
     * <code>SQLException</code> will be generated when the
     * <code>PreparedStatement</code> is executed. This method differs from the
     * <code>setCharacterStream (int, Reader, int)</code> method because it
     * informs the driver that the parameter value should be sent to the server
     * as a <code>NCLOB</code>. When the <code>setCharacterStream</code> method
     * is used, the driver may have to do extra work to determine whether the
     * parameter data should be sent to the server as a
     * <code>LONGNVARCHAR</code> or a <code>NCLOB</code>
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader         An object that contains the data to set the parameter value
     *                       to.
     * @param length         the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the length specified is less than
     *                      zero; if the driver does not support national character sets;
     *                      if the driver can detect that a data conversion error could
     *                      occur; if a database access error occurs or this method is
     *                      called on a closed <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        currentPreparedStatement.setNClob(parameterIndex, reader, length);

    }

    /**
     * Sets the designated parameter to the given <code>java.sql.SQLXML</code>
     * object. The driver converts this to an SQL <code>XML</code> value when it
     * sends it to the database.
     * <p>
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param xmlObject      a <code>SQLXML</code> object that maps an SQL <code>XML</code>
     *                       value
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs; this
     *                      method is called on a closed <code>PreparedStatement</code>
     *                      or the <code>java.xml.transform.Result</code>,
     *                      <code>Writer</code> or <code>OutputStream</code> has not been
     *                      closed for the <code>SQLXML</code> object
     * @since 1.6
     */
    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        currentPreparedStatement.setSQLXML(parameterIndex, xmlObject);

    }

    /**
     * <p>
     * Sets the value of the designated parameter with the given object. The
     * second argument must be an object type; for integral values, the
     * <code>java.lang</code> equivalent objects should be used.
     * <p>
     * If the second argument is an <code>InputStream</code> then the stream
     * must contain the number of bytes specified by scaleOrLength. If the
     * second argument is a <code>Reader</code> then the reader must contain the
     * number of characters specified by scaleOrLength. If these conditions are
     * not true the driver will generate a <code>SQLException</code> when the
     * prepared statement is executed.
     * <p>
     * <p>
     * The given Java object will be converted to the given targetSqlType before
     * being sent to the database.
     * <p>
     * If the object has a custom mapping (is of a class implementing the
     * interface <code>SQLData</code>), the JDBC driver should call the method
     * <code>SQLData.writeSQL</code> to write it to the SQL data stream. If, on
     * the other hand, the object is of a class implementing <code>Ref</code>,
     * <code>Blob</code>, <code>Clob</code>, <code>NClob</code>,
     * <code>Struct</code>, <code>java.net.URL</code>, or <code>Array</code>,
     * the driver should pass it to the database as a value of the corresponding
     * SQL type.
     * <p>
     * <p>
     * Note that this method may be used to pass database-specific abstract data
     * types.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the object containing the input parameter value
     * @param targetSqlType  the SQL type (as defined in java.sql.Types) to be sent to the
     *                       database. The scale argument may further qualify this type.
     * @param scaleOrLength  for <code>java.sql.Types.DECIMAL</code> or
     *                       <code>java.sql.Types.NUMERIC types</code>, this is the number
     *                       of digits after the decimal point. For Java Object types
     *                       <code>InputStream</code> and <code>Reader</code>, this is the
     *                       length of the data in the stream or reader. For all other
     *                       types, this value will be ignored.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs; this method is called on a closed
     *                      <code>PreparedStatement</code> or if the Java Object
     *                      specified by x is an InputStream or Reader object and the
     *                      value of the scale parameter is less than zero
     * @see java.sql.Types
     * @since 1.6
     */
    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        currentPreparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);

    }

    /**
     * Sets the designated parameter to the given input stream, which will have
     * the specified number of bytes. When a very large ASCII value is input to
     * a <code>LONGVARCHAR</code> parameter, it may be more practical to send it
     * via a <code>java.io.InputStream</code>. Data will be read from the stream
     * as needed until end-of-file is reached. The JDBC driver will do any
     * necessary conversion from ASCII to the database char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the Java input stream that contains the ASCII parameter value
     * @param length         the number of bytes in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        currentPreparedStatement.setAsciiStream(parameterIndex, x, length);

    }

    /**
     * Sets the designated parameter to the given input stream, which will have
     * the specified number of bytes. When a very large binary value is input to
     * a <code>LONGVARBINARY</code> parameter, it may be more practical to send
     * it via a <code>java.io.InputStream</code> object. The data will be read
     * from the stream as needed until end-of-file is reached.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the java input stream which contains the binary parameter
     *                       value
     * @param length         the number of bytes in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        currentPreparedStatement.setBinaryStream(parameterIndex, x, length);

    }

    /**
     * Sets the designated parameter to the given <code>Reader</code> object,
     * which is the given number of characters long. When a very large UNICODE
     * value is input to a <code>LONGVARCHAR</code> parameter, it may be more
     * practical to send it via a <code>java.io.Reader</code> object. The data
     * will be read from the stream as needed until end-of-file is reached. The
     * JDBC driver will do any necessary conversion from UNICODE to the database
     * char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param reader         the <code>java.io.Reader</code> object that contains the
     *                       Unicode data
     * @param length         the number of characters in the stream
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        currentPreparedStatement.setCharacterStream(parameterIndex, reader, length);

    }

    /**
     * Sets the designated parameter to the given input stream. When a very
     * large ASCII value is input to a <code>LONGVARCHAR</code> parameter, it
     * may be more practical to send it via a <code>java.io.InputStream</code>.
     * Data will be read from the stream as needed until end-of-file is reached.
     * The JDBC driver will do any necessary conversion from ASCII to the
     * database char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of <code>setAsciiStream</code>
     * which takes a length parameter.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the Java input stream that contains the ASCII parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        currentPreparedStatement.setAsciiStream(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given input stream. When a very
     * large binary value is input to a <code>LONGVARBINARY</code> parameter, it
     * may be more practical to send it via a <code>java.io.InputStream</code>
     * object. The data will be read from the stream as needed until end-of-file
     * is reached.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of <code>setBinaryStream</code>
     * which takes a length parameter.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x              the java input stream which contains the binary parameter
     *                       value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        currentPreparedStatement.setBinaryStream(parameterIndex, x);

    }

    /**
     * Sets the designated parameter to the given <code>Reader</code> object.
     * When a very large UNICODE value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.Reader</code> object. The data will be read from the stream
     * as needed until end-of-file is reached. The JDBC driver will do any
     * necessary conversion from UNICODE to the database char format.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of
     * <code>setCharacterStream</code> which takes a length parameter.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param reader         the <code>java.io.Reader</code> object that contains the
     *                       Unicode data
     * @throws SQLException if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        currentPreparedStatement.setCharacterStream(parameterIndex, reader);

    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. The
     * <code>Reader</code> reads the data till end-of-file is reached. The
     * driver does the necessary conversion from Java character format to the
     * national character set in the database.
     * <p>
     * <p>
     * <B>Note:</B> This stream object can either be a standard Java stream
     * object or your own subclass that implements the standard interface.
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of
     * <code>setNCharacterStream</code> which takes a length parameter.
     *
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value          the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the driver does not support national
     *                      character sets; if the driver can detect that a data
     *                      conversion error could occur; if a database access error
     *                      occurs; or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        currentPreparedStatement.setNCharacterStream(parameterIndex, value);
    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. This
     * method differs from the <code>setCharacterStream (int, Reader)</code>
     * method because it informs the driver that the parameter value should be
     * sent to the server as a <code>CLOB</code>. When the
     * <code>setCharacterStream</code> method is used, the driver may have to do
     * extra work to determine whether the parameter data should be sent to the
     * server as a <code>LONGVARCHAR</code> or a <code>CLOB</code>
     * <p>
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of <code>setClob</code> which
     * takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader         An object that contains the data to set the parameter value
     *                       to.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs; this
     *                      method is called on a closed <code>PreparedStatement</code>or
     *                      if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement
     * @since 1.6
     */
    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        currentPreparedStatement.setClob(parameterIndex, reader);

    }

    /**
     * Sets the designated parameter to a <code>InputStream</code> object. This
     * method differs from the <code>setBinaryStream (int, InputStream)</code>
     * method because it informs the driver that the parameter value should be
     * sent to the server as a <code>BLOB</code>. When the
     * <code>setBinaryStream</code> method is used, the driver may have to do
     * extra work to determine whether the parameter data should be sent to the
     * server as a <code>LONGVARBINARY</code> or a <code>BLOB</code>
     * <p>
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of <code>setBlob</code> which
     * takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param inputStream    An object that contains the data to set the parameter value
     *                       to.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if a database access error occurs; this
     *                      method is called on a closed <code>PreparedStatement</code>
     *                      or if parameterIndex does not correspond to a parameter
     *                      marker in the SQL statement,
     * @since 1.6
     */
    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        currentPreparedStatement.setBlob(parameterIndex, inputStream);

    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. This
     * method differs from the <code>setCharacterStream (int, Reader)</code>
     * method because it informs the driver that the parameter value should be
     * sent to the server as a <code>NCLOB</code>. When the
     * <code>setCharacterStream</code> method is used, the driver may have to do
     * extra work to determine whether the parameter data should be sent to the
     * server as a <code>LONGNVARCHAR</code> or a <code>NCLOB</code>
     * <p>
     * <B>Note:</B> Consult your JDBC driver documentation to determine if it
     * might be more efficient to use a version of <code>setNClob</code> which
     * takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader         An object that contains the data to set the parameter value
     *                       to.
     * @throws SQLException if parameterIndex does not correspond to a parameter marker
     *                      in the SQL statement; if the driver does not support national
     *                      character sets; if the driver can detect that a data
     *                      conversion error could occur; if a database access error
     *                      occurs or this method is called on a closed
     *                      <code>PreparedStatement</code>
     * @since 1.6
     */
    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        currentPreparedStatement.setNClob(parameterIndex, reader);

    }

    /**
     * 执行结束后关闭连接
     *
     * @throws SQLException SQL异常
     * @see java.sql.Statement#closeOnCompletion()
     */
    @Override
    public void closeOnCompletion() throws SQLException {
    }

    /**
     * 是否关闭连接
     *
     * @return 布尔值
     * @throws SQLException SQL异常
     * @see java.sql.Statement#isCloseOnCompletion()
     */
    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return false;
    }

}
