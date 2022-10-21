package com.nestdigital.twiter.Dao;

import com.nestdigital.twiter.Model.SignupModel;
import org.springframework.data.repository.CrudRepository;

public interface SignupDao extends CrudRepository<SignupModel,Integer> {
}
