package io.github.djerohn.manager;

import io.github.djerohn.exception.DbTestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DbManager {

	public static void executeQueries(Sql2o client, String sqlQueries) {
		try (Connection connection = client.open()) {
			for (String sqlQuery : sqlQueries.split(";")) {
				executeUpdate(connection, sqlQuery);
			}
		} catch (Sql2oException e) {
			throw new DbTestException(e);
		}
	}

	public static void executeScript(Sql2o client, String sqlScript) {
		try (Connection connection = client.open()) {
			executeUpdate(connection, sqlScript);
		} catch (Sql2oException e) {
			throw new DbTestException(e);
		}
	}

	public static List<Map<String, Object>> executeAndFetchResult(Sql2o client, String sqlQuery) {
		try (Connection connection = client.open()) {
			return executeSelect(connection, sqlQuery);
		} catch (Sql2oException e) {
			throw new DbTestException(e);
		}
	}

	private static List<Map<String, Object>> executeSelect(Connection connection, String sqlQuery) {
		try (Query query = connection.createQuery(sqlQuery)) {
			return query.executeAndFetchTable().asList();
		} catch (Sql2oException e) {
			throw new DbTestException(e);
		}
	}

	private static void executeUpdate(Connection connection, String sqlQuery) {
		try (Query query = connection.createQuery(sqlQuery)) {
			query.executeUpdate();
		} catch (Sql2oException e) {
			throw new DbTestException(e);
		}
	}
}
