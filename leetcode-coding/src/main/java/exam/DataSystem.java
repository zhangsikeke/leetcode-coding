package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

public class DataSystem {

	// key 设备id，value：接收到的数据，
	// 第二层map中 key表示数据id，value：set 记录数据从哪里发来
	private Map<Integer, Map<Integer, Set<Integer>>> map = new HashMap<>();
	// 存放贡献值
	private Map<Integer, Integer> mapValue = new HashMap<>();
	private int totalMachineNum = 0;

	public DataSystem(int num) {
		totalMachineNum = num;
		for (int i = 1; i < num + 1; i++) {
			map.put(i, new HashMap<>());
			mapValue.put(i, 0);
		}

	}

	// 发送数据
	public int translateData(int machineA, int machineB, int dataId) {
		if (map.get(machineB).containsKey(dataId)) {
			return 0;
		}
		Set<Integer> from = map.get(machineB).get(dataId);
		if (from == null) {
			from = new HashSet<>();
			map.get(machineB).put(dataId, from);
		}
		from.add(machineA);
		System.out.println(machineB + "-receive-" + dataId + " total " + map.get(machineB));
		updateValue(machineB, dataId);
		return 1;
	}

	// 发送所有数据
	public int translateAllData(int machine, int dataId) {
		int total = 0;
		for (int i = 1; i < totalMachineNum + 1; i++) {
			if (i != machine) {
				int res = translateData(machine, i, dataId);
				if (res == 1) {
					total++;
				}
			}
		}
		return total;
	}

	// 查询贡献值
	public int queryMachineValue(int machine) {
		return mapValue.get(machine);
	}

	private void updateValue(int machineId, int dataId) {
		if (map.get(machineId).isEmpty()) {
			return;
		}
		if (!map.get(machineId).containsKey(dataId)) {
			return;
		}
		Set<Integer> machineIdSet = map.get(machineId).get(dataId);
		// System.out.println(dataId+"->" + machineIdSet);
		for (Integer fromMachineId : machineIdSet) {
			mapValue.put(fromMachineId, mapValue.getOrDefault(fromMachineId, 0) + 10);
			updateValue(fromMachineId, dataId);
		}

	}

	public static void main(String[] args) {
		DataSystem testSystem = new DataSystem(4);
		System.out.println(testSystem.translateData(1, 2, 35));
		System.out.println(testSystem.translateData(2, 3, 35));
		System.out.println(testSystem.translateData(3, 4, 35));

		System.out.println(testSystem.translateData(1, 2, 27));
		System.out.println(testSystem.translateData(4, 3, 30));
		System.out.println(testSystem.translateData(3, 1, 27));
		System.out.println(testSystem.translateData(3, 1, 27));

		System.out.println(testSystem.translateAllData(3, 50));

		System.out.println(testSystem.queryMachineValue(1));
		System.out.println(testSystem.queryMachineValue(2));
		System.out.println(testSystem.queryMachineValue(3));
		System.out.println(testSystem.queryMachineValue(4));

	}
}
