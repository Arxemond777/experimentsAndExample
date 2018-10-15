package treenode;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ContractorController {
//    private ContractorService contractorService;
//
//    public ItemNode<JcontractorsSlaveDTO> getChildrenTreeById(
//            @PathVariable Long id,
//            @RequestParam(value = "isDeleted", required = false) Boolean isDeletedFilter) {
//
//        Condition condition = JooqKeeper.BTS.contractors.ID.eq(id);
//        Boolean isDeleted = null;
//
//        if (nonNull(isDeletedFilter))
//            condition = condition.and(JooqKeeper.BTS.contractors.IS_DELETED.eq(isDeletedFilter));
//
//        JcontractorsSlaveDTO parent = jooqKeeper.getDsl()
//                .select(JooqKeeper.BTS.contractors.ID, JooqKeeper.BTS.contractors.NAME)
//                .from(JooqKeeper.BTS.contractors)
//                .where(condition)
//                .fetchOne(contractor -> jooqKeeper.getMapper().map(contractor, JcontractorsSlaveDTO.class));
//
//        ItemNode<JcontractorsSlaveDTO> jContractorsNode = new ItemNode<>(parent);
//
//        contractorService.getChildrenByContractor(jContractorsNode, parent.getId(), isDeleted);
//
//        return jContractorsNode;
//    }
}


