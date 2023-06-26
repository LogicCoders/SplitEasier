package com.SplitEasier.spliteasier.repository;

import com.SplitEasier.spliteasier.model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,String> {
}
