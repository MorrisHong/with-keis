package kr.gracelove.gethandson.account.application.port.in;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/27
 */

public interface SendMoneyUseCase {

	boolean sendMoney(SendMoneyCommand command);
}
