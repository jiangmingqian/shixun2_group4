package controller;

public class CasesComment {
	private int _id; 
	private String _name;
	private String _method;
	private String _url;
	private String _param;
	private String _owner;
	private Object _date;

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_method() {
		return _method;
	}

	public void set_method(String _method) {
		this._method = _method;
	}

	public String get_url() {
		return _url;
	}

	public void set_url(String _url) {
		this._url = _url;
	}

	public String get_param() {
		return _param;
	}

	public void set_param(String _param) {
		this._param = _param;
	}
 
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_owner() {
		return _owner;
	}

	public void set_owner(String _owner) {
		this._owner = _owner;
	}

	public Object get_date() {
		return _date;
	}

	public void set_date(Object _date) {
		this._date = _date;
	}

	public CasesComment(int comment_id, String comment_name,String comment_method,String comment_url,String comment_param,String comment_owner, Object comment_date) {
		super();
		this._id = comment_id;
		this._name = comment_name;
		this._method = comment_method;
		this._url = comment_url;
		this._param = comment_param;
		this._owner = comment_owner;
		this._date = comment_date;
	}
	
	public CasesComment() {
 
	}
	
}
