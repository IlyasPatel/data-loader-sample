package datasets

import com.efinancialcareers.enums.CompanyType
import com.efinancialcareers.enums.CurrencyType
import com.efinancialcareers.enums.EmploymentType
import com.efinancialcareers.enums.EntityStatus
import com.efinancialcareers.enums.InventoryType
import com.efinancialcareers.enums.Location
import com.efinancialcareers.enums.PositionType
import com.efinancialcareers.enums.SalaryBand
import com.efinancialcareers.enums.SubSector
import com.efinancialcareers.enums.YearsExperience
import com.efinancialcareers.qa.newDomain.Company
import com.efinancialcareers.qa.newDomain.CompanyAddress
import com.efinancialcareers.qa.newDomain.Contract
import com.efinancialcareers.qa.newDomain.Inventory
import com.efinancialcareers.qa.newDomain.InventoryAllocation
import com.efinancialcareers.qa.newDomain.Job
import com.efinancialcareers.qa.newDomain.JobAllocation
import com.efinancialcareers.qa.newDomain.JobDescription
import com.efinancialcareers.qa.newDomain.Team
import org.apache.commons.lang.RandomStringUtils

def random = RandomStringUtils.randomAlphabetic(10)
def londonLocationId = Location.LONDON.getLocationId()
def globalLocationId = Location.GLOBAL.getLocationId()
def companyId = 116
def brandId = 5714
def userId = 13564
def jobTemplateId = 1
def subSectorId = SubSector.DEBT_FIXED_INCOME__SALES_TRADING.id
def yearsExpId = YearsExperience.NO_EXPERIENCE.id
def currencyId = CurrencyType.GBP.id
def salaryBandId = SalaryBand.FIRST_TIER.id
def positionTypeId = PositionType.PERMANENT.id
def empTypeId = EmploymentType.FULL_TIME.id
def activeStatus = EntityStatus.ACTIVE.id

def inventoryStartDt = Calendar.instance
inventoryStartDt.add(Calendar.DATE, -1)

def inventoryExpDt = Calendar.instance
inventoryExpDt.add(Calendar.MONTH, 2)

table(Job, ['version', 'locationId', 'companyId', 'brandId', 'usrId', 'subSector1Id', 'yearsExperience', 'jobReference', 'salaryCurrency', 'salaryBand',
            'positionType', 'employmentType', 'applicationMethod', 'jobProviderId', 'autoReply', 'screenQuestionary', 'jobTemplateId']) {
    jobResult = row 0, londonLocationId, companyId, brandId, userId, subSectorId, yearsExpId, random, currencyId, salaryBandId, positionTypeId, empTypeId, 1, 0, false, false, jobTemplateId
}

table(JobDescription, ['title', 'description', 'summary', 'salaryDescription', 'permitRequirements', 'languageCode', 'defaultDescription', 'job']) {
    jobDescResult = row 'Test job in Berlin', 'This is a test job.', 'summary', 'Excellent', 'DE Work Permit', 'EN', 1, jobResult
}

table(Company, ['version', 'name', 'siebelReferenceNumber', 'url', 'ofccpCompliant', 'socialCvSearchEnabled', 'socialCvSearchShowPhotoEnabled', 'allowExternalAppsWithoutLogin', 'status', 'type']) {
    companyResult = row 0, 'CompanyNameRandom' + {random}, 'Random27', 'http://www.random.com', false, false, false, false, activeStatus, CompanyType.RECRUITMENT_AGENCY.id
}

table(CompanyAddress, ['version', 'address1', 'address2', 'address3', 'locationId', 'postalCode', 'phone', 'fax', 'email', 'company']) {
    companyAddResult = row 0, 'Company add 1', 'Company add 2', 'Company add 3', londonLocationId, '', '', '', 'companyRandom@company.com', companyResult
}

table(Contract, ['version', 'contractRefNum', 'company']) {
    contractResult = row 0, 'refNum19Random', companyResult
}

table(Inventory, ['version', 'contract', 'locationId', 'amount', 'startDt', 'expirationDt', 'inventorySubTypeId', 'status']) {
    inventoryResult = row 0, contractResult, globalLocationId, 200, inventoryStartDt, inventoryExpDt, InventoryType.CREDIT.id, activeStatus
}

table(Team, ['version', 'name', 'company', 'status']) {
    teamResult = row 0, 'TeamRandom', companyResult, activeStatus
}

table(InventoryAllocation, ['version', 'inventory', 'team', 'totalAmount', 'status']) {
    inventoryAllocationResult = row 0, inventoryResult, teamResult, 50, activeStatus
}

table(JobAllocation, ['version', 'inventoryAllocation', 'job', 'startDt', 'expirationDt']) {
    jobAllocationResult = row 0, inventoryAllocationResult, jobResult, inventoryStartDt, inventoryExpDt
}




