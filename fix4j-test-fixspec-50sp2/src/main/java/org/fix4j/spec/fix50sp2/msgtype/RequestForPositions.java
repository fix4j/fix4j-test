package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class RequestForPositions extends BaseMsgType{
    public static final RequestForPositions INSTANCE = new RequestForPositions();

    private RequestForPositions() {
        super(
            "RequestForPositions",
            "AN",
            "app",
            FieldTypes.PosReqID.required(true),
            FieldTypes.PosReqType.required(true),
            FieldTypes.MatchStatus.required(false),
            FieldTypes.SubscriptionRequestType.required(false),
            FieldTypes.SettlCurrency.required(false),
            new BaseGroupType(
                FieldTypes.NoPartyIDs.required(false),
                FieldTypes.PartyID.required(false),
                FieldTypes.PartyIDSource.required(false),
                FieldTypes.PartyRole.required(false),
                new BaseGroupType(
                    FieldTypes.NoPartySubIDs.required(false),
                    FieldTypes.PartySubID.required(false),
                    FieldTypes.PartySubIDType.required(false)
                )
            ),
            FieldTypes.Account.required(false),
            FieldTypes.AcctIDSource.required(false),
            FieldTypes.AccountType.required(false),
            FieldTypes.Symbol.required(false),
            FieldTypes.SymbolSfx.required(false),
            FieldTypes.SecurityID.required(false),
            FieldTypes.SecurityIDSource.required(false),
            new BaseGroupType(
                FieldTypes.NoSecurityAltID.required(false),
                FieldTypes.SecurityAltID.required(false),
                FieldTypes.SecurityAltIDSource.required(false)
            ),
            FieldTypes.Product.required(false),
            FieldTypes.SecurityGroup.required(false),
            FieldTypes.ProductComplex.required(false),
            FieldTypes.CFICode.required(false),
            FieldTypes.SecurityType.required(false),
            FieldTypes.SecuritySubType.required(false),
            FieldTypes.MaturityMonthYear.required(false),
            FieldTypes.MaturityDate.required(false),
            FieldTypes.SecurityStatus.required(false),
            FieldTypes.SettleOnOpenFlag.required(false),
            FieldTypes.InstrmtAssignmentMethod.required(false),
            FieldTypes.MaturityTime.required(false),
            FieldTypes.CouponPaymentDate.required(false),
            FieldTypes.RestructuringType.required(false),
            FieldTypes.Seniority.required(false),
            FieldTypes.NotionalPercentageOutstanding.required(false),
            FieldTypes.OriginalNotionalPercentageOutstanding.required(false),
            FieldTypes.AttachmentPoint.required(false),
            FieldTypes.DetachmentPoint.required(false),
            FieldTypes.IssueDate.required(false),
            FieldTypes.RepoCollateralSecurityType.required(false),
            FieldTypes.RepurchaseTerm.required(false),
            FieldTypes.RepurchaseRate.required(false),
            FieldTypes.Factor.required(false),
            FieldTypes.CreditRating.required(false),
            FieldTypes.InstrRegistry.required(false),
            FieldTypes.CountryOfIssue.required(false),
            FieldTypes.StateOrProvinceOfIssue.required(false),
            FieldTypes.LocaleOfIssue.required(false),
            FieldTypes.RedemptionDate.required(false),
            FieldTypes.StrikePrice.required(false),
            FieldTypes.StrikeCurrency.required(false),
            FieldTypes.StrikeMultiplier.required(false),
            FieldTypes.StrikeValue.required(false),
            FieldTypes.StrikePriceDeterminationMethod.required(false),
            FieldTypes.StrikePriceBoundaryMethod.required(false),
            FieldTypes.StrikePriceBoundaryPrecision.required(false),
            FieldTypes.UnderlyingPriceDeterminationMethod.required(false),
            FieldTypes.OptAttribute.required(false),
            FieldTypes.ContractMultiplier.required(false),
            FieldTypes.MinPriceIncrement.required(false),
            FieldTypes.UnitOfMeasure.required(false),
            FieldTypes.TimeUnit.required(false),
            FieldTypes.MinPriceIncrementAmount.required(false),
            FieldTypes.UnitOfMeasureQty.required(false),
            FieldTypes.PriceUnitOfMeasure.required(false),
            FieldTypes.PriceUnitOfMeasureQty.required(false),
            FieldTypes.SettlMethod.required(false),
            FieldTypes.ExerciseStyle.required(false),
            FieldTypes.OptPayoutAmount.required(false),
            FieldTypes.PriceQuoteMethod.required(false),
            FieldTypes.ListMethod.required(false),
            FieldTypes.CapPrice.required(false),
            FieldTypes.FloorPrice.required(false),
            FieldTypes.PutOrCall.required(false),
            FieldTypes.FlexibleIndicator.required(false),
            FieldTypes.FlexProductEligibilityIndicator.required(false),
            FieldTypes.ValuationMethod.required(false),
            FieldTypes.ContractMultiplierUnit.required(false),
            FieldTypes.FlowScheduleType.required(false),
            FieldTypes.OptPayoutType.required(false),
            FieldTypes.CouponRate.required(false),
            FieldTypes.SecurityExchange.required(false),
            FieldTypes.PositionLimit.required(false),
            FieldTypes.NTPositionLimit.required(false),
            FieldTypes.Issuer.required(false),
            FieldTypes.EncodedIssuerLen.required(false),
            FieldTypes.EncodedIssuer.required(false),
            FieldTypes.SecurityDesc.required(false),
            FieldTypes.EncodedSecurityDescLen.required(false),
            FieldTypes.EncodedSecurityDesc.required(false),
            FieldTypes.SecurityXMLLen.required(false),
            FieldTypes.SecurityXML.required(false),
            FieldTypes.SecurityXMLSchema.required(false),
            FieldTypes.Pool.required(false),
            FieldTypes.ContractSettlMonth.required(false),
            FieldTypes.CPProgram.required(false),
            FieldTypes.CPRegType.required(false),
            new BaseGroupType(
                FieldTypes.NoEvents.required(false),
                FieldTypes.EventType.required(false),
                FieldTypes.EventDate.required(false),
                FieldTypes.EventTime.required(false),
                FieldTypes.EventPx.required(false),
                FieldTypes.EventText.required(false)
            ),
            FieldTypes.DatedDate.required(false),
            FieldTypes.InterestAccrualDate.required(false),
            new BaseGroupType(
                FieldTypes.NoInstrumentParties.required(false),
                FieldTypes.InstrumentPartyID.required(false),
                FieldTypes.InstrumentPartyIDSource.required(false),
                FieldTypes.InstrumentPartyRole.required(false),
                new BaseGroupType(
                    FieldTypes.NoInstrumentPartySubIDs.required(false),
                    FieldTypes.InstrumentPartySubID.required(false),
                    FieldTypes.InstrumentPartySubIDType.required(false)
                )
            ),
            new BaseGroupType(
                FieldTypes.NoComplexEvents.required(false),
                FieldTypes.ComplexEventType.required(false),
                FieldTypes.ComplexOptPayoutAmount.required(false),
                FieldTypes.ComplexEventPrice.required(false),
                FieldTypes.ComplexEventPriceBoundaryMethod.required(false),
                FieldTypes.ComplexEventPriceBoundaryPrecision.required(false),
                FieldTypes.ComplexEventPriceTimeType.required(false),
                FieldTypes.ComplexEventCondition.required(false),
                new BaseGroupType(
                    FieldTypes.NoComplexEventDates.required(false),
                    FieldTypes.ComplexEventStartDate.required(false),
                    FieldTypes.ComplexEventEndDate.required(false),
                    new BaseGroupType(
                        FieldTypes.NoComplexEventTimes.required(false),
                        FieldTypes.ComplexEventStartTime.required(false),
                        FieldTypes.ComplexEventEndTime.required(false)
                    )
                )
            ),
            FieldTypes.Currency.required(false),
            new BaseGroupType(
                FieldTypes.NoLegs.required(false),
                FieldTypes.LegSymbol.required(false),
                FieldTypes.LegSymbolSfx.required(false),
                FieldTypes.LegSecurityID.required(false),
                FieldTypes.LegSecurityIDSource.required(false),
                new BaseGroupType(
                    FieldTypes.NoLegSecurityAltID.required(false),
                    FieldTypes.NoLegSecurityAltID.required(false),
                    FieldTypes.LegSecurityAltID.required(false),
                    FieldTypes.LegSecurityAltIDSource.required(false)
                ),
                FieldTypes.LegProduct.required(false),
                FieldTypes.LegCFICode.required(false),
                FieldTypes.LegSecurityType.required(false),
                FieldTypes.LegSecuritySubType.required(false),
                FieldTypes.LegMaturityMonthYear.required(false),
                FieldTypes.LegMaturityDate.required(false),
                FieldTypes.LegMaturityTime.required(false),
                FieldTypes.LegCouponPaymentDate.required(false),
                FieldTypes.LegIssueDate.required(false),
                FieldTypes.LegRepoCollateralSecurityType.required(false),
                FieldTypes.LegRepurchaseTerm.required(false),
                FieldTypes.LegRepurchaseRate.required(false),
                FieldTypes.LegFactor.required(false),
                FieldTypes.LegCreditRating.required(false),
                FieldTypes.LegInstrRegistry.required(false),
                FieldTypes.LegCountryOfIssue.required(false),
                FieldTypes.LegStateOrProvinceOfIssue.required(false),
                FieldTypes.LegLocaleOfIssue.required(false),
                FieldTypes.LegRedemptionDate.required(false),
                FieldTypes.LegStrikePrice.required(false),
                FieldTypes.LegStrikeCurrency.required(false),
                FieldTypes.LegOptAttribute.required(false),
                FieldTypes.LegContractMultiplier.required(false),
                FieldTypes.LegUnitOfMeasure.required(false),
                FieldTypes.LegTimeUnit.required(false),
                FieldTypes.LegExerciseStyle.required(false),
                FieldTypes.LegUnitOfMeasureQty.required(false),
                FieldTypes.LegPriceUnitOfMeasure.required(false),
                FieldTypes.LegPriceUnitOfMeasureQty.required(false),
                FieldTypes.LegContractMultiplierUnit.required(false),
                FieldTypes.LegFlowScheduleType.required(false),
                FieldTypes.LegCouponRate.required(false),
                FieldTypes.LegSecurityExchange.required(false),
                FieldTypes.LegIssuer.required(false),
                FieldTypes.EncodedLegIssuerLen.required(false),
                FieldTypes.EncodedLegIssuer.required(false),
                FieldTypes.LegSecurityDesc.required(false),
                FieldTypes.EncodedLegSecurityDescLen.required(false),
                FieldTypes.EncodedLegSecurityDesc.required(false),
                FieldTypes.LegRatioQty.required(false),
                FieldTypes.LegSide.required(false),
                FieldTypes.LegCurrency.required(false),
                FieldTypes.LegPool.required(false),
                FieldTypes.LegDatedDate.required(false),
                FieldTypes.LegContractSettlMonth.required(false),
                FieldTypes.LegInterestAccrualDate.required(false),
                FieldTypes.LegOptionRatio.required(false),
                FieldTypes.LegPrice.required(false),
                FieldTypes.LegPutOrCall.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoUnderlyings.required(false),
                FieldTypes.UnderlyingSymbol.required(false),
                FieldTypes.UnderlyingSymbolSfx.required(false),
                FieldTypes.UnderlyingSecurityID.required(false),
                FieldTypes.UnderlyingSecurityIDSource.required(false),
                new BaseGroupType(
                    FieldTypes.NoUnderlyingSecurityAltID.required(false),
                    FieldTypes.UnderlyingSecurityAltID.required(false),
                    FieldTypes.UnderlyingSecurityAltIDSource.required(false)
                ),
                FieldTypes.UnderlyingProduct.required(false),
                FieldTypes.UnderlyingCFICode.required(false),
                FieldTypes.UnderlyingSecurityType.required(false),
                FieldTypes.UnderlyingSecuritySubType.required(false),
                FieldTypes.UnderlyingMaturityMonthYear.required(false),
                FieldTypes.UnderlyingMaturityDate.required(false),
                FieldTypes.UnderlyingMaturityTime.required(false),
                FieldTypes.UnderlyingCouponPaymentDate.required(false),
                FieldTypes.UnderlyingRestructuringType.required(false),
                FieldTypes.UnderlyingSeniority.required(false),
                FieldTypes.UnderlyingNotionalPercentageOutstanding.required(false),
                FieldTypes.UnderlyingOriginalNotionalPercentageOutstanding.required(false),
                FieldTypes.UnderlyingAttachmentPoint.required(false),
                FieldTypes.UnderlyingDetachmentPoint.required(false),
                FieldTypes.UnderlyingIssueDate.required(false),
                FieldTypes.UnderlyingRepoCollateralSecurityType.required(false),
                FieldTypes.UnderlyingRepurchaseTerm.required(false),
                FieldTypes.UnderlyingRepurchaseRate.required(false),
                FieldTypes.UnderlyingFactor.required(false),
                FieldTypes.UnderlyingCreditRating.required(false),
                FieldTypes.UnderlyingInstrRegistry.required(false),
                FieldTypes.UnderlyingCountryOfIssue.required(false),
                FieldTypes.UnderlyingStateOrProvinceOfIssue.required(false),
                FieldTypes.UnderlyingLocaleOfIssue.required(false),
                FieldTypes.UnderlyingRedemptionDate.required(false),
                FieldTypes.UnderlyingStrikePrice.required(false),
                FieldTypes.UnderlyingStrikeCurrency.required(false),
                FieldTypes.UnderlyingOptAttribute.required(false),
                FieldTypes.UnderlyingContractMultiplier.required(false),
                FieldTypes.UnderlyingUnitOfMeasure.required(false),
                FieldTypes.UnderlyingTimeUnit.required(false),
                FieldTypes.UnderlyingExerciseStyle.required(false),
                FieldTypes.UnderlyingUnitOfMeasureQty.required(false),
                FieldTypes.UnderlyingPriceUnitOfMeasure.required(false),
                FieldTypes.UnderlyingPriceUnitOfMeasureQty.required(false),
                FieldTypes.UnderlyingContractMultiplierUnit.required(false),
                FieldTypes.UnderlyingFlowScheduleType.required(false),
                FieldTypes.UnderlyingCouponRate.required(false),
                FieldTypes.UnderlyingSecurityExchange.required(false),
                FieldTypes.UnderlyingIssuer.required(false),
                FieldTypes.EncodedUnderlyingIssuerLen.required(false),
                FieldTypes.EncodedUnderlyingIssuer.required(false),
                FieldTypes.UnderlyingSecurityDesc.required(false),
                FieldTypes.EncodedUnderlyingSecurityDescLen.required(false),
                FieldTypes.EncodedUnderlyingSecurityDesc.required(false),
                FieldTypes.UnderlyingCPProgram.required(false),
                FieldTypes.UnderlyingCPRegType.required(false),
                FieldTypes.UnderlyingAllocationPercent.required(false),
                FieldTypes.UnderlyingCurrency.required(false),
                FieldTypes.UnderlyingQty.required(false),
                FieldTypes.UnderlyingSettlementType.required(false),
                FieldTypes.UnderlyingCashAmount.required(false),
                FieldTypes.UnderlyingCashType.required(false),
                FieldTypes.UnderlyingPx.required(false),
                FieldTypes.UnderlyingDirtyPrice.required(false),
                FieldTypes.UnderlyingEndPrice.required(false),
                FieldTypes.UnderlyingStartValue.required(false),
                FieldTypes.UnderlyingCurrentValue.required(false),
                FieldTypes.UnderlyingEndValue.required(false),
                FieldTypes.UnderlyingAdjustedQuantity.required(false),
                FieldTypes.UnderlyingFXRate.required(false),
                FieldTypes.UnderlyingFXRateCalc.required(false),
                new BaseGroupType(
                    FieldTypes.NoUnderlyingStips.required(false),
                    FieldTypes.UnderlyingStipType.required(false),
                    FieldTypes.UnderlyingStipValue.required(false)
                ),
                FieldTypes.UnderlyingCapValue.required(false),
                FieldTypes.UnderlyingSettlMethod.required(false),
                FieldTypes.UnderlyingPutOrCall.required(false),
                new BaseGroupType(
                    FieldTypes.NoUndlyInstrumentParties.required(false),
                    FieldTypes.UnderlyingInstrumentPartyID.required(false),
                    FieldTypes.UnderlyingInstrumentPartyIDSource.required(false),
                    FieldTypes.UnderlyingInstrumentPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoUndlyInstrumentPartySubIDs.required(false),
                        FieldTypes.UnderlyingInstrumentPartySubID.required(false),
                        FieldTypes.UnderlyingInstrumentPartySubIDType.required(false)
                    )
                )
            ),
            FieldTypes.ClearingBusinessDate.required(true),
            FieldTypes.SettlSessID.required(false),
            FieldTypes.SettlSessSubID.required(false),
            new BaseGroupType(
                FieldTypes.NoTradingSessions.required(false),
                FieldTypes.TradingSessionID.required(false),
                FieldTypes.TradingSessionSubID.required(false)
            ),
            FieldTypes.TransactTime.required(true),
            FieldTypes.ResponseTransportType.required(false),
            FieldTypes.ResponseDestination.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false)
        );
    }
}