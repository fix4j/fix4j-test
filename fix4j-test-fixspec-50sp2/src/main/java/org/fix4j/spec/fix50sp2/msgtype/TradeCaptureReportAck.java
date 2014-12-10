package org.fix4j.spec.fix50sp2.msgtype;

import org.fix4j.test.fixspec.BaseGroupType;
import org.fix4j.test.fixspec.BaseMsgType;
import org.fix4j.spec.fix50sp2.FieldTypes;

public class TradeCaptureReportAck extends BaseMsgType{
    public static final TradeCaptureReportAck INSTANCE = new TradeCaptureReportAck();

    private TradeCaptureReportAck() {
        super(
            "TradeCaptureReportAck",
            "AR",
            "app",
            FieldTypes.TradeReportID.required(false),
            FieldTypes.TradeID.required(false),
            FieldTypes.SecondaryTradeID.required(false),
            FieldTypes.FirmTradeID.required(false),
            FieldTypes.SecondaryFirmTradeID.required(false),
            FieldTypes.TradeReportTransType.required(false),
            FieldTypes.TradeReportType.required(false),
            FieldTypes.TrdType.required(false),
            FieldTypes.TrdSubType.required(false),
            FieldTypes.SecondaryTrdType.required(false),
            FieldTypes.TradeHandlingInstr.required(false),
            FieldTypes.OrigTradeHandlingInstr.required(false),
            FieldTypes.OrigTradeDate.required(false),
            FieldTypes.OrigTradeID.required(false),
            FieldTypes.OrigSecondaryTradeID.required(false),
            FieldTypes.TransferReason.required(false),
            new BaseGroupType(
                FieldTypes.NoRootPartyIDs.required(false),
                FieldTypes.RootPartyID.required(false),
                FieldTypes.RootPartyIDSource.required(false),
                FieldTypes.RootPartyRole.required(false),
                new BaseGroupType(
                    FieldTypes.NoRootPartySubIDs.required(false),
                    FieldTypes.RootPartySubID.required(false),
                    FieldTypes.RootPartySubIDType.required(false)
                )
            ),
            FieldTypes.ExecType.required(false),
            FieldTypes.TradeReportRefID.required(false),
            FieldTypes.SecondaryTradeReportRefID.required(false),
            FieldTypes.TrdRptStatus.required(false),
            FieldTypes.TradeReportRejectReason.required(false),
            FieldTypes.SecondaryTradeReportID.required(false),
            FieldTypes.SubscriptionRequestType.required(false),
            FieldTypes.TradeLinkID.required(false),
            FieldTypes.TrdMatchID.required(false),
            FieldTypes.ExecID.required(false),
            FieldTypes.SecondaryExecID.required(false),
            FieldTypes.ExecRestatementReason.required(false),
            FieldTypes.PreviouslyReported.required(false),
            FieldTypes.PriceType.required(false),
            FieldTypes.UnderlyingTradingSessionID.required(false),
            FieldTypes.QtyType.required(false),
            FieldTypes.UnderlyingTradingSessionSubID.required(false),
            FieldTypes.LastQty.required(false),
            FieldTypes.LastPx.required(false),
            FieldTypes.SettlSessID.required(false),
            FieldTypes.SettlSessSubID.required(false),
            FieldTypes.VenueType.required(false),
            FieldTypes.MarketSegmentID.required(false),
            FieldTypes.MarketID.required(false),
            FieldTypes.LastParPx.required(false),
            FieldTypes.LastSpotRate.required(false),
            FieldTypes.LastForwardPoints.required(false),
            FieldTypes.LastMkt.required(false),
            FieldTypes.TradeDate.required(false),
            FieldTypes.ClearingBusinessDate.required(false),
            FieldTypes.AvgPx.required(false),
            FieldTypes.AvgPxIndicator.required(false),
            FieldTypes.MultiLegReportingType.required(false),
            FieldTypes.TradeLegRefID.required(false),
            FieldTypes.CalculatedCcyLastQty.required(false),
            FieldTypes.LastSwapPoints.required(false),
            FieldTypes.Currency.required(false),
            FieldTypes.SettlCurrency.required(false),
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
            FieldTypes.TransactTime.required(false),
            FieldTypes.SettlType.required(false),
            FieldTypes.MatchStatus.required(false),
            FieldTypes.MatchType.required(false),
            FieldTypes.CopyMsgIndicator.required(false),
            FieldTypes.PublishTrdIndicator.required(false),
            FieldTypes.ShortSaleReason.required(false),
            FieldTypes.TradePublishIndicator.required(false),
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
                FieldTypes.LegPutOrCall.required(false),
                FieldTypes.LegQty.required(false),
                FieldTypes.LegSwapType.required(false),
                FieldTypes.LegReportID.required(false),
                FieldTypes.LegNumber.required(false),
                new BaseGroupType(
                    FieldTypes.NoLegStipulations.required(false),
                    FieldTypes.LegStipulationType.required(false),
                    FieldTypes.LegStipulationValue.required(false)
                ),
                FieldTypes.LegPositionEffect.required(false),
                FieldTypes.LegCoveredOrUncovered.required(false),
                new BaseGroupType(
                    FieldTypes.NoNestedPartyIDs.required(false),
                    FieldTypes.NestedPartyID.required(false),
                    FieldTypes.NestedPartyIDSource.required(false),
                    FieldTypes.NestedPartyRole.required(false),
                    new BaseGroupType(
                        FieldTypes.NoNestedPartySubIDs.required(false),
                        FieldTypes.NestedPartySubID.required(false),
                        FieldTypes.NestedPartySubIDType.required(false)
                    )
                ),
                FieldTypes.LegRefID.required(false),
                FieldTypes.LegSettlType.required(false),
                FieldTypes.LegSettlDate.required(false),
                FieldTypes.LegLastPx.required(false),
                FieldTypes.LegSettlCurrency.required(false),
                FieldTypes.LegLastForwardPoints.required(false),
                FieldTypes.LegCalculatedCcyLastQty.required(false),
                FieldTypes.LegGrossTradeAmt.required(false),
                FieldTypes.LegVolatility.required(false),
                FieldTypes.LegDividendYield.required(false),
                FieldTypes.LegCurrencyRatio.required(false),
                FieldTypes.LegExecInst.required(false),
                FieldTypes.LegLastQty.required(false),
                new BaseGroupType(
                    FieldTypes.NoOfLegUnderlyings.required(false),
                    FieldTypes.UnderlyingLegSymbol.required(false),
                    FieldTypes.UnderlyingLegSymbolSfx.required(false),
                    FieldTypes.UnderlyingLegSecurityID.required(false),
                    FieldTypes.UnderlyingLegSecurityIDSource.required(false),
                    new BaseGroupType(
                        FieldTypes.NoUnderlyingLegSecurityAltID.required(false),
                        FieldTypes.UnderlyingLegSecurityAltID.required(false),
                        FieldTypes.UnderlyingLegSecurityAltIDSource.required(false)
                    ),
                    FieldTypes.UnderlyingLegCFICode.required(false),
                    FieldTypes.UnderlyingLegSecurityType.required(false),
                    FieldTypes.UnderlyingLegSecuritySubType.required(false),
                    FieldTypes.UnderlyingLegMaturityMonthYear.required(false),
                    FieldTypes.UnderlyingLegMaturityDate.required(false),
                    FieldTypes.UnderlyingLegMaturityTime.required(false),
                    FieldTypes.UnderlyingLegStrikePrice.required(false),
                    FieldTypes.UnderlyingLegOptAttribute.required(false),
                    FieldTypes.UnderlyingLegPutOrCall.required(false),
                    FieldTypes.UnderlyingLegSecurityExchange.required(false),
                    FieldTypes.UnderlyingLegSecurityDesc.required(false)
                )
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
            new BaseGroupType(
                FieldTypes.NoTrdRepIndicators.required(false),
                FieldTypes.TrdRepPartyRole.required(false),
                FieldTypes.TrdRepIndicator.required(false)
            ),
            new BaseGroupType(
                FieldTypes.NoTrdRegTimestamps.required(false),
                FieldTypes.TrdRegTimestamp.required(false),
                FieldTypes.TrdRegTimestampType.required(false),
                FieldTypes.TrdRegTimestampOrigin.required(false),
                FieldTypes.DeskType.required(false),
                FieldTypes.DeskTypeSource.required(false),
                FieldTypes.DeskOrderHandlingInst.required(false)
            ),
            FieldTypes.ResponseTransportType.required(false),
            FieldTypes.ResponseDestination.required(false),
            FieldTypes.Text.required(false),
            FieldTypes.EncodedTextLen.required(false),
            FieldTypes.EncodedText.required(false),
            FieldTypes.AsOfIndicator.required(false),
            FieldTypes.ClearingFeeIndicator.required(false),
            FieldTypes.TierCode.required(false),
            FieldTypes.MessageEventSource.required(false),
            FieldTypes.LastUpdateTime.required(false),
            FieldTypes.RndPx.required(false),
            new BaseGroupType(
                FieldTypes.NoPosAmt.required(false),
                FieldTypes.PosAmtType.required(false),
                FieldTypes.PosAmt.required(false),
                FieldTypes.PositionCurrency.required(false)
            ),
            FieldTypes.SettlDate.required(false),
            FieldTypes.GrossTradeAmt.required(false),
            FieldTypes.RptSys.required(false),
            new BaseGroupType(
                FieldTypes.NoSides.required(true),
                FieldTypes.Side.required(true),
                FieldTypes.SideExecID.required(false),
                FieldTypes.OrderDelay.required(false),
                FieldTypes.OrderDelayUnit.required(false),
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
                FieldTypes.ProcessCode.required(false),
                FieldTypes.OddLot.required(false),
                new BaseGroupType(
                    FieldTypes.NoClearingInstructions.required(false),
                    FieldTypes.ClearingInstruction.required(false)
                ),
                FieldTypes.TradeInputSource.required(false),
                FieldTypes.TradeInputDevice.required(false),
                FieldTypes.ComplianceID.required(false),
                FieldTypes.SolicitedFlag.required(false),
                FieldTypes.CustOrderCapacity.required(false),
                FieldTypes.TradingSessionID.required(false),
                FieldTypes.TradingSessionSubID.required(false),
                FieldTypes.TimeBracket.required(false),
                FieldTypes.NetGrossInd.required(false),
                FieldTypes.SideCurrency.required(false),
                FieldTypes.SideSettlCurrency.required(false),
                FieldTypes.Commission.required(false),
                FieldTypes.CommType.required(false),
                FieldTypes.CommCurrency.required(false),
                FieldTypes.FundRenewWaiv.required(false),
                FieldTypes.NumDaysInterest.required(false),
                FieldTypes.ExDate.required(false),
                FieldTypes.AccruedInterestRate.required(false),
                FieldTypes.AccruedInterestAmt.required(false),
                FieldTypes.InterestAtMaturity.required(false),
                FieldTypes.EndAccruedInterestAmt.required(false),
                FieldTypes.StartCash.required(false),
                FieldTypes.EndCash.required(false),
                FieldTypes.Concession.required(false),
                FieldTypes.TotalTakedown.required(false),
                FieldTypes.NetMoney.required(false),
                FieldTypes.SettlCurrAmt.required(false),
                FieldTypes.SettlCurrFxRate.required(false),
                FieldTypes.SettlCurrFxRateCalc.required(false),
                FieldTypes.PositionEffect.required(false),
                FieldTypes.SideMultiLegReportingType.required(false),
                new BaseGroupType(
                    FieldTypes.NoContAmts.required(false),
                    FieldTypes.ContAmtType.required(false),
                    FieldTypes.ContAmtValue.required(false),
                    FieldTypes.ContAmtCurr.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoStipulations.required(false),
                    FieldTypes.StipulationType.required(false),
                    FieldTypes.StipulationValue.required(false)
                ),
                new BaseGroupType(
                    FieldTypes.NoMiscFees.required(false),
                    FieldTypes.MiscFeeAmt.required(false),
                    FieldTypes.MiscFeeCurr.required(false),
                    FieldTypes.MiscFeeType.required(false),
                    FieldTypes.MiscFeeBasis.required(false)
                ),
                FieldTypes.ExchangeRule.required(false),
                new BaseGroupType(
                    FieldTypes.NoSettlDetails.required(false),
                    FieldTypes.SettlObligSource.required(false),
                    new BaseGroupType(
                        FieldTypes.NoSettlPartyIDs.required(false),
                        FieldTypes.SettlPartyID.required(false),
                        FieldTypes.SettlPartyIDSource.required(false),
                        FieldTypes.SettlPartyRole.required(false),
                        new BaseGroupType(
                            FieldTypes.NoSettlPartySubIDs.required(false),
                            FieldTypes.SettlPartySubID.required(false),
                            FieldTypes.SettlPartySubIDType.required(false)
                        )
                    )
                ),
                FieldTypes.TradeAllocIndicator.required(false),
                FieldTypes.PreallocMethod.required(false),
                FieldTypes.AllocID.required(false),
                FieldTypes.SideGrossTradeAmt.required(false),
                FieldTypes.AggressorIndicator.required(false),
                FieldTypes.SideLastQty.required(false),
                FieldTypes.SideTradeReportID.required(false),
                FieldTypes.SideFillStationCd.required(false),
                FieldTypes.SideReasonCd.required(false),
                FieldTypes.RptSeq.required(false),
                new BaseGroupType(
                    FieldTypes.NoAllocs.required(false),
                    FieldTypes.AllocAccount.required(false),
                    FieldTypes.AllocAcctIDSource.required(false),
                    FieldTypes.AllocSettlCurrency.required(false),
                    FieldTypes.IndividualAllocID.required(false),
                    new BaseGroupType(
                        FieldTypes.NoNested2PartyIDs.required(false),
                        FieldTypes.Nested2PartyID.required(false),
                        FieldTypes.Nested2PartyIDSource.required(false),
                        FieldTypes.Nested2PartyRole.required(false),
                        new BaseGroupType(
                            FieldTypes.NoNested2PartySubIDs.required(false),
                            FieldTypes.Nested2PartySubID.required(false),
                            FieldTypes.Nested2PartySubIDType.required(false)
                        )
                    ),
                    FieldTypes.AllocQty.required(false),
                    FieldTypes.AllocCustomerCapacity.required(false),
                    FieldTypes.AllocMethod.required(false),
                    FieldTypes.SecondaryIndividualAllocID.required(false),
                    FieldTypes.AllocClearingFeeIndicator.required(false)
                ),
                FieldTypes.SideTrdSubTyp.required(false),
                FieldTypes.OrderCategory.required(false),
                new BaseGroupType(
                    FieldTypes.NoSideTrdRegTS.required(false),
                    FieldTypes.SideTrdRegTimestamp.required(false),
                    FieldTypes.SideTrdRegTimestampType.required(false),
                    FieldTypes.SideTrdRegTimestampSrc.required(false)
                ),
                FieldTypes.OrderID.required(false),
                FieldTypes.SecondaryOrderID.required(false),
                FieldTypes.ClOrdID.required(false),
                FieldTypes.SecondaryClOrdID.required(false),
                FieldTypes.ListID.required(false),
                FieldTypes.RefOrderID.required(false),
                FieldTypes.RefOrderIDSource.required(false),
                FieldTypes.RefOrdIDReason.required(false),
                FieldTypes.OrdType.required(false),
                FieldTypes.Price.required(false),
                FieldTypes.StopPx.required(false),
                FieldTypes.ExecInst.required(false),
                FieldTypes.OrdStatus.required(false),
                FieldTypes.OrderQty.required(false),
                FieldTypes.CashOrderQty.required(false),
                FieldTypes.OrderPercent.required(false),
                FieldTypes.RoundingDirection.required(false),
                FieldTypes.RoundingModulus.required(false),
                FieldTypes.LeavesQty.required(false),
                FieldTypes.CumQty.required(false),
                FieldTypes.TimeInForce.required(false),
                FieldTypes.ExpireTime.required(false),
                FieldTypes.DisplayQty.required(false),
                FieldTypes.SecondaryDisplayQty.required(false),
                FieldTypes.DisplayWhen.required(false),
                FieldTypes.DisplayMethod.required(false),
                FieldTypes.DisplayLowQty.required(false),
                FieldTypes.DisplayHighQty.required(false),
                FieldTypes.DisplayMinIncr.required(false),
                FieldTypes.RefreshQty.required(false),
                FieldTypes.OrderCapacity.required(false),
                FieldTypes.OrderRestrictions.required(false),
                FieldTypes.BookingType.required(false),
                FieldTypes.OrigCustOrderCapacity.required(false),
                FieldTypes.OrderInputDevice.required(false),
                FieldTypes.LotType.required(false),
                FieldTypes.TransBkdTime.required(false),
                FieldTypes.OrigOrdModTime.required(false)
            ),
            FieldTypes.FeeMultiplier.required(false)
        );
    }
}