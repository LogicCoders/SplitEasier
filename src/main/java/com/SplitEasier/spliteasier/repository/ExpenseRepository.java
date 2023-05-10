package com.SplitEasier.spliteasier.repository;

import com.SplitEasier.spliteasier.model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense,String> {
}
