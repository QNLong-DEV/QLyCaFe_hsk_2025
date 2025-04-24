package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import model.ChiTietDonHang;

public class DanhSachChiTietDonHang {
	private ArrayList<ChiTietDonHang> list;

	public DanhSachChiTietDonHang() {
		list = new ArrayList<ChiTietDonHang>();
	}

	public ArrayList<ChiTietDonHang> getList() {
		return list;
	}

	public void setList(ArrayList<ChiTietDonHang> list) {
		this.list = list;
	}

	public void trimToSize() {
		list.trimToSize();
	}

	public void ensureCapacity(int minCapacity) {
		list.ensureCapacity(minCapacity);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	public boolean contains(Object o) {
		return list.contains(o);
	}

	public int indexOf(Object o) {
		return list.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	public Object clone() {
		return list.clone();
	}

	public Object[] toArray() {
		return list.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	public String toString() {
		return list.toString();
	}

	public ChiTietDonHang get(int index) {
		return list.get(index);
	}

	public ChiTietDonHang getFirst() {
		return list.getFirst();
	}

	public ChiTietDonHang getLast() {
		return list.getLast();
	}

	public ChiTietDonHang set(int index, ChiTietDonHang element) {
		return list.set(index, element);
	}

	public boolean add(ChiTietDonHang e) {
		return list.add(e);
	}

	public void add(int index, ChiTietDonHang element) {
		list.add(index, element);
	}

	public void addFirst(ChiTietDonHang element) {
		list.addFirst(element);
	}

	public void addLast(ChiTietDonHang element) {
		list.addLast(element);
	}

	public ChiTietDonHang remove(int index) {
		return list.remove(index);
	}

	public ChiTietDonHang removeFirst() {
		return list.removeFirst();
	}

	public <T> T[] toArray(IntFunction<T[]> generator) {
		return list.toArray(generator);
	}

	public ChiTietDonHang removeLast() {
		return list.removeLast();
	}

	public boolean equals(Object o) {
		return list.equals(o);
	}

	public int hashCode() {
		return list.hashCode();
	}

	public boolean remove(Object o) {
		return list.remove(o);
	}

	public void clear() {
		list.clear();
	}

	public boolean addAll(Collection<? extends ChiTietDonHang> c) {
		return list.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends ChiTietDonHang> c) {
		return list.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	public ListIterator<ChiTietDonHang> listIterator(int index) {
		return list.listIterator(index);
	}

	public ListIterator<ChiTietDonHang> listIterator() {
		return list.listIterator();
	}

	public Iterator<ChiTietDonHang> iterator() {
		return list.iterator();
	}

	public Stream<ChiTietDonHang> stream() {
		return list.stream();
	}

	public Stream<ChiTietDonHang> parallelStream() {
		return list.parallelStream();
	}

	public List<ChiTietDonHang> reversed() {
		return list.reversed();
	}

	public List<ChiTietDonHang> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	public void forEach(Consumer<? super ChiTietDonHang> action) {
		list.forEach(action);
	}

	public Spliterator<ChiTietDonHang> spliterator() {
		return list.spliterator();
	}

	public boolean removeIf(Predicate<? super ChiTietDonHang> filter) {
		return list.removeIf(filter);
	}

	public void replaceAll(UnaryOperator<ChiTietDonHang> operator) {
		list.replaceAll(operator);
	}

	public void sort(Comparator<? super ChiTietDonHang> c) {
		list.sort(c);
	}

	public void themChiTiet(ChiTietDonHang chiTiet) {
		list.add(chiTiet);
	}

	public boolean xoaChiTiet(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public double tongTien() {
		if (list == null || list.isEmpty())
			return 0;
		double res = 0;
		for (ChiTietDonHang x : list) {
			res += x.getThanhTien();
		}
		return res;
	}

	public double tongTienMotNuoc(String ma) {
		double thanhtien = 0;
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(ma)) {
				thanhtien += x.getSoLuong() * x.getDonGia();
			}
		}
		return thanhtien;
	}

	public boolean xoaToanBo() {
		if (list != null && !list.isEmpty()) {
			list.clear();
			return true;
		}
		return false;
	}

	public double tangSoLuonNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl + 1);
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}

	public double giamSoLuongNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl - 1);
				if (x.getSoLuong() <= 0) {
					list.remove(x);
					break;
				}
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}

	public double tangSoLuongNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl + 1);
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}

	public String xuat() {
		String res = "";
		for (ChiTietDonHang x : list) {
			res += x.toString() + "\n";
		}
		return res;
	}
}
