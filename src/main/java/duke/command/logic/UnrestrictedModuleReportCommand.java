package duke.command.logic;

import duke.command.logic.CoreModuleReportCommand;
import duke.modules.data.ModuleInfoDetailed;
import duke.modules.data.ModuleTask;
import duke.util.JsonWrapper;
import duke.util.PlannerUi;
import duke.util.Storage;
import duke.util.commons.ModuleTasksList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UnrestrictedModuleReportCommand extends ModuleCommand {

    public UnrestrictedModuleReportCommand() {

    }

    private Set<String> coreModList = new HashSet<>();

    private Set<String> getCoreModList() {
        coreModList.add("CG111");
        coreModList.add("CG112");
        coreModList.add("CS1010");
        coreModList.add("CS1231");
        coreModList.add("MA1511");
        coreModList.add("MA1512");
        coreModList.add("M1508E");
        coreModList.add("CG2023");
        coreModList.add("CG2027");
        coreModList.add("CG2028");
        coreModList.add("CG2271");
        coreModList.add("CS2040C");
        coreModList.add("CS2101");
        coreModList.add("EE2026");
        coreModList.add("EG2401A");
        coreModList.add("ST2334");
        coreModList.add("CG3207");
        coreModList.add("CP3380");
        coreModList.add("EG3611A");
        coreModList.add("CG4002");
        coreModList.add("EE4204");
        return coreModList;
    }

    @Override
    public void execute(HashMap<String, ModuleInfoDetailed> detailedMap,
                        ModuleTasksList tasks,
                        PlannerUi plannerUi,
                        Storage store,
                        JsonWrapper jsonWrapper) {
        plannerUi.ueModReport();
        int count = 1;
        coreModList = getCoreModList();

        for (int i = 0; i < tasks.getTasks().size(); i++) {
            String moduleCode = tasks.getTasks().get(i).getModuleInfoDetailed().getModuleCode();
            if((!coreModList.contains(moduleCode)) && !moduleCode.startsWith("GE")) {
                ModuleTask temp = tasks.getTasks().get(i);
                System.out.println(count + ". " + temp);
                count++;
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
