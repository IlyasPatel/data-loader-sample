import com.efinancialcareers.domain.Company
import com.efinancialcareers.domain.CompanyAddress
import com.efinancialcareers.domain.CompanyType
import com.efinancialcareers.domain.EntityStatus
import org.apache.commons.lang3.RandomStringUtils


def random = RandomStringUtils.randomAlphabetic(10)
def allowExternalAppsWithoutLogin = false
def activeStatus = EntityStatus.ACTIVE.id

table(Company, ['version', 'name', 'siebelReferenceNumber', 'url', 'ofccpCompliant', 'socialCvSearchEnabled', 'socialCvSearchShowPhotoEnabled', 'allowExternalAppsWithoutLogin', 'status', 'type']) {
    companyResult = row 0, "CompanyInCanada ${random}", "${random}", "http://www.random.com", false, false, false, allowExternalAppsWithoutLogin, activeStatus, CompanyType.RECRUITMENT_AGENCY.id
}
table(CompanyAddress, ['version', 'address1', 'address2', 'address3', 'locationId', 'postalCode', 'phone', 'fax', 'email', 'company']) {
    companyAddResult = row 0, 'Company add 1', 'Company add 2', 'Company add 3', 2643743, 'K1S 5R5', '123456789', '', "company${random}@mailinator.com", companyResult
}
