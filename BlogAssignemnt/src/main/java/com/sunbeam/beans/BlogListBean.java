package com.sunbeam.beans;

import java.util.List;

import com.mysql.cj.jdbc.Blob;
import com.sunbeam.daos.BlogDao;
import com.sunbeam.entities.Blog;

public class BlogListBean {
	private List<Blog> blogList;
	private int userId;
	private int candidateId;
	private int count;
	private Blog blog;
	
	public BlogListBean() {
		
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public void getBlogs() {
		try(BlogDao blogDao = new BlogDao()){
			blogList = blogDao.findAll();
			
//			for (Blog blog : blogList) {
//				System.out.println(blog);
//			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
