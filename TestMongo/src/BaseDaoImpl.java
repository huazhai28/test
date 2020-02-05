import java.util.List;



/**
 * @author Mr Lin
 * 封装mongo的基础DAO
 */
public class BaseDaoImpl{
    	private MongoSession session;

    	public BaseDaoImpl(){
    		session = GetDataBase.session;
    	}
    	
    //存入一条记录	
    public void save(Object obj) {
    this.session.save(obj);
    }
    //删除符合条件的第一条记录,obj里放了多少数据就有多少条件(必须同时满足所有条件)
    public void deleteOne(Object obj) {
        try {
            this.session.delete(obj);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

  //删除符合条件的所有记录,obj里放了多少数据就有多少条件(必须同时满足所有条件)
    public void deleteAll(Object obj) {
        try {
            this.session.deleteAll(obj);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //根据ID修改一条记录
    public void updateOne(Object obj) {
        this.session.update(obj);
    }
    
  //根据条件修改所有记录，第一个参数是条件，第二个参数是要修改的值(必须同时满足所有条件)
    public void updateAll(Object arg,Object val) {
        this.session.updateAll(arg,val);
    }

    //通过ID查询一条记录
    public Object findOne(Object obj) {
        // TODO Auto-generated method stub
        return this.session.find(obj);
    }
    //通过条件查询所有记录(必须同时满足所有条件)
    public List findMany(Object obj) {
        // TODO Auto-generated method stub
        return this.session.findAll(obj);
    }
    //查询所有记录(无条件)
    public List finds(Object obj) {
        // TODO Auto-generated method stub
        return this.session.finds(obj);
    }

    //查询总记录条数
    public long total(Object obj) {
        // TODO Auto-generated method stub
        return this.session.count(obj);
    }

    
    public List<Object> finds(int index, int offset) {
        // TODO Auto-generated method stub
        return this.session.query(null, null, offset, index);
    }

    
    
}