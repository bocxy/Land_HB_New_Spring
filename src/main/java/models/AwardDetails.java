package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "awarddetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // Award details
   private String filename;

    private String landname;
    private String award_details_no;
    private String award_details_date;
    private String award_details_survey_nos;
    private String award_details_extent;
    private String award_details_notified_person;
    private String award_details_award_amount;
    private String award_details_disbursement_direct_payment;
    private String award_details_disbursement_revenue_deposit;
    private String award_details_disbursement_civil_court_deposit;

//pho details
    private String pho_survey_nos;
    private String pho_extent;
    private String pho_schimpl_survey_nos;
    private String pho_schimpl_extent;

    private String pho_extcannot_survey_nos;
    private String pho_extcannot_extent;
    private String pho_extcannot_court_case;
    private String pho_extcannot_wantofapproach;
    private String pho_extcannot_encroachment;
    private String pho_extcannot_scattered;
    private String pho_extcannot_quashed;
    private String pho_extcannot_reconveyed;
    private String pho_extcannot_noc_issued;
    private String pho_extavailable_survey_nos;
    private String pho_extavailable_extent;

    //pnho
    private String pnho_survey_nos;
    private String pnho_extent;
    private String pnho_court_case;
    private String pnho_encroachment;
    private String pnho_quashed;
    private String pnho_without_encumbrance;

    private String left_lps_4one_extent;
    private String left_lps_4one_survey_nos;
    private String left_4one_6d_extent;
    private String left_4one_6d_survey_nos;
    private String left_6d_award_extent;
    private String left_6d_award_extent_survey_nos;



}
