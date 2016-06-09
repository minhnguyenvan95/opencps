/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package org.opencps.paymentmgt.util;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author trungdk
 */
public class PaymentMgtUtil {
	public static final int PAYMENT_STATUS_ON_PROCESSING = 0;
	public static final int PAYMENT_STATUS_REQUESTED = 1;
	public static final int PAYMENT_STATUS_CONFIRMED = 2;
	public static final int PAYMENT_STATUS_APPROVED = 3;
	public static final int PAYMENT_STATUS_REJECTED = 4;
	
	/**
	 * @param ownerUserId
	 * @param ownerOrgId
	 * @return
	 */
	public static String getOwnerPayment(long ownerUserId, long ownerOrgId) {
		String ownerName = StringPool.BLANK;
		
		if (ownerUserId != 0) {
			try {
				User user = UserLocalServiceUtil.fetchUser(ownerUserId);
				ownerName = user.getFullName();
            }
            catch (Exception e) {
	            // TODO: handle exception
            }
		}
		
		if (ownerOrgId != 0) {
			try {
	            Organization org = OrganizationLocalServiceUtil.fetchOrganization(ownerOrgId);
	            ownerName = org.getName();
            }
            catch (Exception e) {
	            // TODO: handle exception
            }
		}
		
		return ownerName;
	}
}
