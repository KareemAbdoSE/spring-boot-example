package com.kareemabdo.customer;


import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        // Given
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getInt("age")).thenReturn(19);
        when(resultSet.getString("name")).thenReturn("kareem");
        when(resultSet.getString("email")).thenReturn("kareem@gmail.com");
        when(resultSet.getString("gender")).thenReturn("MALE");

        // When
        Customer actual = customerRowMapper.mapRow(resultSet, 1);

        // Then
        Customer expected = new Customer(
                1, "kareem", "kareem@gmail.com", "password", 19,
                Gender.MALE);
        assertThat(actual).isEqualTo(expected);
    }
}
