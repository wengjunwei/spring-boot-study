package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.App;
import com.dao.UsersRepository;
import com.dao.UsersRepositoryByName;
import com.dao.UsersRepositoryGrudRepository;
import com.dao.UsersRepositoryJpaSpecificationExecutor;
import com.dao.UsersRepositoryPagingAndSort;
import com.dao.UsersRepositoryQueryAnnotation;
import com.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryByName usersRepositoryByName;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	
	@Autowired
	private UsersRepositoryGrudRepository usersRepositoryGrudRepository;
	
	@Autowired
	private UsersRepositoryPagingAndSort usersRepositoryPagingAndSort;
	
	@Autowired
	private UsersRepositoryJpaSpecificationExecutor usersRepositoryJpaSpecificationExecutor;
	
	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testSave(){
		Users users=new Users();
		users.setAddress("北京");
		users.setAge("18");
		users.setName("张三");
		this.usersRepository.save(users);
	}
	
	
	@Test
	public void testFindByName(){
		List<Users> list=this.usersRepositoryByName.findByName("张三");
		for(Users users:list){
			System.out.println(users);
		}
	}
	
	@Test
	public void testFindByNameAndAge(){
		List<Users> list=this.usersRepositoryByName.findByNameAndAge("张三", "18");
		for(Users users:list){
			System.out.println(users);
		}
	}
	
	
	@Test
	public void testFindByNameLike(){
		List<Users> list=this.usersRepositoryByName.findByNameLike("张%");
		for(Users users:list){
			System.out.println(users);
		}
	}
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseHQL(){
		List<Users> list=this.usersRepositoryQueryAnnotation.queryByNameUseHQL("张三");
		for(Users users:list){
			System.out.println(users);
		}
	}
	
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseSQL(){
		List<Users> list=this.usersRepositoryQueryAnnotation.queryByNameUseSQL("张三");
		for(Users users:list){
			System.out.println(users);
		}
	}
	
	
	/**
	 * Repository--@Query测试
	 */
	@Test
	@Transactional //@Transactional与@Test 一起使用时 事务是自动回滚的。
	@Rollback(false) //取消自动回滚
	public void testUpdateUsersNameById(){
		this.usersRepositoryQueryAnnotation.updateUsersNameById("张三三", 2);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositorySave(){
		Users users=new Users();
		users.setAddress("北京");
		users.setAge("19");
		users.setName("小四");
		this.usersRepositoryGrudRepository.save(users);
	}
	
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryUpdate(){
		Users users=new Users();
		users.setId(3);
		users.setAddress("北京啊");
		users.setAge("29");
		users.setName("小四");
		this.usersRepositoryGrudRepository.save(users);
	}
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindOne(){
		Users users=this.usersRepositoryGrudRepository.findOne(3);
		System.out.println(users);
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryFindAll(){
		List<Users> list=(List<Users>)this.usersRepositoryGrudRepository.findAll();
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	/**
	 * CrudRepository测试
	 */
	@Test
	public void testCrudRepositoryDelete(){
		this.usersRepositoryGrudRepository.delete(3);
	}
	
	
	/**
	 * PagingAndSortingRepository 排序
	 */
	@Test
	public void testPagingAndSortingSort(){
		Sort sort=new Sort(Direction.DESC, "id");
		List<Users> list=(List<Users>) this.usersRepositoryPagingAndSort.findAll(sort);
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	/**
	 * PagingAndSortingRepository 分页
	 */
	@Test
	public void testPagingAndSortingPaging(){
		//Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前页是从0开始。
		//PageRequest(page,size) page:当前页。size:每页显示的条数
		Pageable pageable=new PageRequest(0, 2);
		Page<Users> page = this.usersRepositoryPagingAndSort.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	/**
	 * PagingAndSortingRepository 分页+排序
	 */
	@Test
	public void testPagingAndSortingPagingAndSort(){
		Sort sort=new Sort(Direction.DESC, "id");
		Pageable pageable=new PageRequest(0, 1, sort);
		Page<Users> page = this.usersRepositoryPagingAndSort.findAll(pageable);
		System.out.println("总条数："+page.getTotalElements());
		System.out.println("总页数:"+page.getTotalPages());
		List<Users> list = page.getContent();
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	
	/**
	 * JpaRepository 测试
	 */
	@Test
	public void testJpaRepositorySort(){
		Sort sort=new Sort(Direction.DESC, "id");
		List<Users> list=this.usersRepository.findAll(sort);
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	
	/**
	 * JpaSpecificationExecutor 单条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor1(){
		/**
		 * Specification<Users>:用于封装查询条件
		 */
		Specification<Users> spec=new Specification<Users>() {
			//Predicate:封装了 单个的查询条件
			/**
			 * Root<Users> root:查询对象的属性的封装。
			 * CriteriaQuery<?> query：封装了我们要执行的查询中的各个部分的信息，select  from order by
			 * CriteriaBuilder cb:查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三三'
				/**
				 * 参数一：查询的条件属性
				 * 参数二：条件的值
				 */
				Predicate pre=cb.equal(root.get("name"), "张三三");
				return pre;
			}
		};
		List<Users> list = this.usersRepositoryJpaSpecificationExecutor.findAll(spec);
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	/**
	 * JpaSpecificationExecutor 多条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor2(){
		Specification spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list=new ArrayList<>();
				list.add(cb.equal(root.get("name"), "张三三"));
				list.add(cb.equal(root.get("age"),"18"));
				Predicate[] arr=new Predicate[list.size()];
				return cb.and(list.toArray(arr));
			}
		};
		List<Users> list=this.usersRepositoryJpaSpecificationExecutor.findAll(spec);
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	/**
	 * JpaSpecificationExecutor 多条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor3(){
		Specification spec=new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				List<Predicate> list=new ArrayList<>();
//				list.add(cb.equal(root.get("name"), "张三三"));
//				list.add(cb.equal(root.get("age"),"18"));
//				Predicate[] arr=new Predicate[list.size()];
				return cb.or(cb.and(cb.equal(root.get("name"), "张三三"),cb.equal(root.get("age"),"18")), cb.equal(root.get("id"),1));
			}
		};
		Sort sort=new Sort(Direction.DESC,"id");
		List<Users> list=this.usersRepositoryJpaSpecificationExecutor.findAll(spec,sort);
		for(Users u:list){
			System.out.println(u);
		}
	}
	
	
}
