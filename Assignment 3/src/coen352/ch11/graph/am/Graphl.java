package coen352.ch11.graph.am;

import coen352.ch4.list.*;

public class Graphl implements Graph {
	ADTList<Integer> vList = new AList<Integer>();
	
	@Override
	public void Init(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public int n() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int e() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int first(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int next(int v, int w) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEdge(int i, int j, int wght) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delEdge(int i, int j) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEdge(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int weight(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMark(int v, int val) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMark(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer[] getFanIn(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int last(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rnext(int v, int w) {
		// TODO Auto-generated method stub
		return 0;
	}

}
