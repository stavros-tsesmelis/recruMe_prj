insert into applicant([first_name],[last_name],[email],[date_of_registration],[years_of_experience],[profession],[region]) values ('dimitris', 'iracleous', 'ath@gmail.com', '1970-02-01', 3, 'engineer', 'athens')
insert into applicant([first_name],[last_name],[email],[date_of_registration],[years_of_experience],[profession],[region]) values ('dim', 'cleous', 'sath@gmail.com', '1979-02-01', 0, 'doctor', 'athens')
insert into applicant([first_name],[last_name],[email],[date_of_registration],[years_of_experience],[profession],[region]) values ('sam', 'leous', 'atih@gmail.com', '2010-02-01', 2, 'engineer', 'thesalia')
insert into applicant([first_name],[last_name],[email],[date_of_registration],[years_of_experience],[profession],[region]) values ('mitris', 'racleous', 'atth@gmail.com', '1970-03-01', 3, 'waitress', 'athens')
insert into applicant([first_name],[last_name],[email],[date_of_registration],[years_of_experience],[profession],[region]) values ('riris', 'irac', 'kath@gmail.com', '2020-02-01', 5, 'software engineer', 'athens')

insert into company([company_name],[region]) values ('alphabank', 'athens')
insert into company([company_name],[region]) values ('eurobank', 'london')
insert into company([company_name],[region]) values ('fitbank', 'athens')


insert into job_offer([job_offer_name],[date_of_offer],[company_id],[applicant_id]) values ('java_developer', '1970-02-01', 1, 1)
insert into job_offer([job_offer_name],[date_of_offer],[company_id],[applicant_id]) values ('java', '1970-02-01', 2, 2)
insert into job_offer([job_offer_name],[date_of_offer],[company_id],[applicant_id]) values ('java_developerSSSS', '1970-02-01', 1, 3)
insert into job_offer([job_offer_name],[date_of_offer],[company_id],[applicant_id]) values ('developerSSSS', '1970-02-01', 3, 4)

--insert into job_offer([job_offer_name],[date_of_offer],[company_id], [applicant_id]) values ('java developer', '1970-02-01', 1, 3)
--insert into job_offer([job_offer_name],[date_of_offer],[company_id], [applicant_id]) values ('java developer', '1970-02-01', 1, 5)


--insert into skill_from_recrume([skill_name], [applicant_id], [job_offer_id]) values ('hard-worker', 1, 3)
--insert into skill_from_recrume([skill_name], [applicant_id], [job_offer_id]) values ('java developer', 2, 3)
--
--insert into skill_from_recrume([skill_name]) values ('kalos')
--insert into skill_from_recrume([skill_name]) values ('kakoooosss')
