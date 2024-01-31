package dev.cata.backend;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TestContainersTest extends AbstractTestcontainers {

    @Test
    void canStartPostgresDB() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
        assertThat(postgreSQLContainer.isCreated()).isTrue();
    }
}
