package treenode;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
public class ContractorService {

//    private JooqKeeper jooqKeeper;
//
//    public void getChildrenByContractor(ItemNode<JcontractorsSlaveDTO> jContractorsNode, Long id, Boolean isDeleted) {
//
//        if (isNull(id) || isNull(jContractorsNode))
//            return;
//
//        Condition condition = JooqKeeper.BTS.contractorToContractorSlave.CONTRACTOR_ID.eq(id);
//        Condition isDeletedCondition = DSL.trueCondition();
//        if (nonNull(isDeleted))
//            isDeletedCondition = condition.and(JooqKeeper.BTS.contractors.IS_DELETED.eq(isDeleted));
//
//        SelectConditionStep<Record2<Long, String>> sql = jooqKeeper.getDsl()
//                .select(
//                        JooqKeeper.BTS.contractors.ID
//                        , JooqKeeper.BTS.contractors.NAME
//                 )
//                .from(JooqKeeper.BTS.contractors)
//                .where(
//                        JooqKeeper.BTS.contractors.ID.in(
//                            jooqKeeper.getDsl()
//                                    .select(JooqKeeper.BTS.contractorToContractorSlave.SLAVE_CONTRACTOR_ID)
//                                    .from(JooqKeeper.BTS.contractorToContractorSlave)
//                                    .where(condition)
//                        )
//                        .and(isDeletedCondition)
//                );
//
//        List<JcontractorsSlaveDTO> result = sql.fetch(contractor -> jooqKeeper.getMapper().map(contractor, JcontractorsSlaveDTO.class));
//
//        if (CollectionUtils.isNotEmpty(result)) {
//            result.forEach(c -> {
//                ItemNode<JcontractorsSlaveDTO> innerNode = jContractorsNode.addChild(c);
//                getChildrenByContractor(innerNode, c.getId(), isDeleted);
//            });
//        }
//    }
}
