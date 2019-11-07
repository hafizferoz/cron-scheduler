package com.privasia.scheduler.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContainerVisit is a Querydsl query type for ContainerVisit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContainerVisit extends EntityPathBase<ContainerVisit> {

    private static final long serialVersionUID = 67937098L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContainerVisit containerVisit = new QContainerVisit("containerVisit");

    public final StringPath alongside = createString("alongside");

    public final NumberPath<java.math.BigDecimal> arrivalDraft = createNumber("arrivalDraft", java.math.BigDecimal.class);

    public final StringPath assignedWharf = createString("assignedWharf");

    public final DateTimePath<java.util.Date> ataDate = createDateTime("ataDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> atbDate = createDateTime("atbDate", java.util.Date.class);

    public final StringPath atbReason = createString("atbReason");

    public final DateTimePath<java.util.Date> atdDate = createDateTime("atdDate", java.util.Date.class);

    public final StringPath atdReason = createString("atdReason");

    public final NumberPath<Integer> avgTotalMoves = createNumber("avgTotalMoves", Integer.class);

    public final NumberPath<Float> berthDelay = createNumber("berthDelay", Float.class);

    public final BooleanPath cmaPartner = createBoolean("cmaPartner");

    public final NumberPath<Integer> containerStackHeight = createNumber("containerStackHeight", Integer.class);

    public final DateTimePath<java.util.Date> cosmosEtaDate = createDateTime("cosmosEtaDate", java.util.Date.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final StringPath ctAllocation = createString("ctAllocation");

    public final StringPath delayReason = createString("delayReason");

    public final NumberPath<java.math.BigDecimal> departureDraft = createNumber("departureDraft", java.math.BigDecimal.class);

    public final NumberPath<Integer> discharge20 = createNumber("discharge20", Integer.class);

    public final NumberPath<Integer> discharge40 = createNumber("discharge40", Integer.class);

    public final NumberPath<Integer> displacementWeight = createNumber("displacementWeight", Integer.class);

    public final QContainerVisit doubleBankWith;

    public final NumberPath<Float> draft = createNumber("draft", Float.class);

    public final NumberPath<Integer> endMeterMark = createNumber("endMeterMark", Integer.class);

    public final DateTimePath<java.util.Date> etaDate = createDateTime("etaDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> etbDate = createDateTime("etbDate", java.util.Date.class);

    public final NumberPath<Integer> etbNotificationHour = createNumber("etbNotificationHour", Integer.class);

    public final DateTimePath<java.util.Date> etdDate = createDateTime("etdDate", java.util.Date.class);

    public final BooleanPath highStack = createBoolean("highStack");

    public final StringPath id = createString("id");

    public final BooleanPath isMotherVessel = createBoolean("isMotherVessel");

    public final BooleanPath isOpusSuccess = createBoolean("isOpusSuccess");

    public final BooleanPath isPriority = createBoolean("isPriority");

    public final StringPath issue = createString("issue");

    public final StringPath lashing = createString("lashing");

    public final DateTimePath<java.util.Date> lastEtbChangeTime = createDateTime("lastEtbChangeTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> lastEtbNotificationTime = createDateTime("lastEtbNotificationTime", java.util.Date.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Integer> loading20 = createNumber("loading20", Integer.class);

    public final NumberPath<Integer> loading40 = createNumber("loading40", Integer.class);

    public final BooleanPath lockAndGo = createBoolean("lockAndGo");

    public final NumberPath<Integer> longCrane = createNumber("longCrane", Integer.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath mainBlocks = createString("mainBlocks");

    public final StringPath marineStatus = createString("marineStatus");

    public final NumberPath<Integer> maxWeight = createNumber("maxWeight", Integer.class);

    public final BooleanPath maxWeightInd = createBoolean("maxWeightInd");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDate = createDateTime("modifiedDate", java.util.Date.class);

    public final NumberPath<Integer> mph = createNumber("mph", Integer.class);

    public final StringPath nextPortCall = createString("nextPortCall");

    public final DateTimePath<java.util.Date> nextTimeTrigger = createDateTime("nextTimeTrigger", java.util.Date.class);

    public final NumberPath<Integer> noOfCranes = createNumber("noOfCranes", Integer.class);

    public final NumberPath<Integer> northBollardMetermark = createNumber("northBollardMetermark", Integer.class);

    public final BooleanPath omit = createBoolean("omit");

    public final StringPath omitPort = createString("omitPort");

    public final StringPath omitReason = createString("omitReason");

    public final StringPath operatorCode = createString("operatorCode");

    public final StringPath opusVesselCode = createString("opusVesselCode");

    public final StringPath opusVesselVoyage = createString("opusVesselVoyage");

    public final StringPath opusVisitNo = createString("opusVisitNo");

    public final NumberPath<Integer> originalMoves = createNumber("originalMoves", Integer.class);

    public final StringPath parentVisit = createString("parentVisit");

    public final StringPath partner = createString("partner");

    public final StringPath payer = createString("payer");

    public final DateTimePath<java.util.Date> pilotIn = createDateTime("pilotIn", java.util.Date.class);

    public final DateTimePath<java.util.Date> pilotOut = createDateTime("pilotOut", java.util.Date.class);

    public final StringPath plannedCrane = createString("plannedCrane");

    public final StringPath planningBy = createString("planningBy");

    public final EnumPath<ContainerVisit.PlanningStatus> planningStatus = createEnum("planningStatus", ContainerVisit.PlanningStatus.class);

    public final StringPath previousCraneMove = createString("previousCraneMove");

    public final BooleanPath primaryVisit = createBoolean("primaryVisit");

    public final StringPath priorityColour = createString("priorityColour");

    public final BooleanPath priorityVisit = createBoolean("priorityVisit");

    public final StringPath referenceId = createString("referenceId");

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Integer> restow = createNumber("restow", Integer.class);

    public final StringPath scn = createString("scn");

    public final StringPath serviceIn = createString("serviceIn");

    public final StringPath serviceOut = createString("serviceOut");

    public final StringPath shipId = createString("shipId");

    public final BooleanPath showBreakdownCraneMove = createBoolean("showBreakdownCraneMove");

    public final DateTimePath<java.util.Date> slowdownEtaDate = createDateTime("slowdownEtaDate", java.util.Date.class);

    public final StringPath slowdownETARemarks = createString("slowdownETARemarks");

    public final NumberPath<Integer> southBollardMatermark = createNumber("southBollardMatermark", Integer.class);

    public final BooleanPath split = createBoolean("split");

    public final BooleanPath stackHeight = createBoolean("stackHeight");

    public final NumberPath<Integer> startMeterMark = createNumber("startMeterMark", Integer.class);

    public final DateTimePath<java.util.Date> targetCompletionDate = createDateTime("targetCompletionDate", java.util.Date.class);

    public final EnumPath<ContainerVisit.TideType> tideType = createEnum("tideType", ContainerVisit.TideType.class);

    public final EnumPath<ContainerVisit.TosFlag> tosFlag = createEnum("tosFlag", ContainerVisit.TosFlag.class);

    public final NumberPath<Integer> totalMoves = createNumber("totalMoves", Integer.class);

    public final DateTimePath<java.util.Date> ucustomsAtaSentDate = createDateTime("ucustomsAtaSentDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> ucustomsAtdSentDate = createDateTime("ucustomsAtdSentDate", java.util.Date.class);

    public final StringPath ucustomsScn = createString("ucustomsScn");

    public final StringPath ucustomsVesselId = createString("ucustomsVesselId");

    public final StringPath vesselCode = createString("vesselCode");

    public final NumberPath<Integer> vesselLoa = createNumber("vesselLoa", Integer.class);

    public final StringPath vesselName = createString("vesselName");

    public final DateTimePath<java.util.Date> vesselReady = createDateTime("vesselReady", java.util.Date.class);

    public final StringPath vesselReadyRemarks = createString("vesselReadyRemarks");

    public final StringPath vesselType = createString("vesselType");

    public final StringPath visitId = createString("visitId");

    public final StringPath voyageIn = createString("voyageIn");

    public final StringPath voyageOut = createString("voyageOut");

    public final StringPath window = createString("window");

    public final StringPath windowStatus = createString("windowStatus");

    public final StringPath yardRemarks = createString("yardRemarks");

    public QContainerVisit(String variable) {
        this(ContainerVisit.class, forVariable(variable), INITS);
    }

    public QContainerVisit(Path<? extends ContainerVisit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContainerVisit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContainerVisit(PathMetadata metadata, PathInits inits) {
        this(ContainerVisit.class, metadata, inits);
    }

    public QContainerVisit(Class<? extends ContainerVisit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.doubleBankWith = inits.isInitialized("doubleBankWith") ? new QContainerVisit(forProperty("doubleBankWith"), inits.get("doubleBankWith")) : null;
    }

}

