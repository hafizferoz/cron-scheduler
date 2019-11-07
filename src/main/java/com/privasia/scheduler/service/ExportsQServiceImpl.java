package com.privasia.scheduler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.privasia.scss.core.model.ExportsQ;
import com.privasia.scss.core.repository.ExportsQRepository;

/**
 * @author Hafiz Feroz
 *
 */
@Service
public class ExportsQServiceImpl implements ExportsQService {

	@Autowired
	private ExportsQRepository exportsQRepository;

	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, readOnly = true)
	public List<ExportsQ> getAllExportsQ() {

		Stream<ExportsQ> list = exportsQRepository.findAll();
		if (list != null)
			return list.collect(Collectors.toCollection(ArrayList::new));
		return null;

	}

	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(ExportsQ exports) {
		exportsQRepository.delete(exports);
	}

}
