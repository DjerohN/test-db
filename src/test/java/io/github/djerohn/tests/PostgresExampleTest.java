package io.github.djerohn.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;
import org.sql2o.quirks.PostgresQuirks;

class PostgresExampleTest {
	private static Sql2o client;

	@BeforeAll
	static void setup() {
		client = new Sql2o("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456", new PostgresQuirks());
	}

	@Test
	void selectAllFromTable() {

	}


}
