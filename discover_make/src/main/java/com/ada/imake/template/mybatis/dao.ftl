package ${dao_p!""};


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  ${entity.name};

public interface ${entity.simpleName}Dao extends CriteriaDao<${entity.simpleName},${id.simpleName}>{
	public Pagination getPage(int pageNo, int pageSize);

	public ${entity.simpleName} findById(${id.simpleName} id);

	public ${entity.simpleName} save(${entity.simpleName} bean);

	public ${entity.simpleName} updateByUpdater(Updater<${entity.simpleName}> updater);

	public ${entity.simpleName} deleteById(${id.simpleName} id);
}