package org.develop.persistence.dao.impl;

import org.develop.persistence.dao.interfaces.IRuotaDao;
import org.develop.persistence.entities.business.Ruota;
import org.springframework.stereotype.Repository;

@Repository
public class RuotaDao extends BaseDao<Ruota, String> implements IRuotaDao{}

