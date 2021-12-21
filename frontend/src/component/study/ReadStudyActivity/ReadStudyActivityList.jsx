import React, { PureComponent } from "react";
import style from "../../../css/study/study_workJournalReading/study_workJournalReading.module.css";

class ReadStudyActivityList extends PureComponent {
    render() {
        return (
          <React.Fragment>
            <div className={style["main__listing-wrap"]}>
              <div className={style["main__listing-title"]}>
                <h4>전체글</h4>
              </div>
              <table className={style["main__listing-table"]}>
                <colgroup>
                  <col className={style["title"]} />
                  <col className={style["writer"]} />
                  <col className={style["date"]} />
                </colgroup>
                <tr>
                  <td>
                    <a href="#">스터디 3주차</a>
                  </td>
                  <td>6기 최부엉</td>
                  <td>2021.07.05</td>
                </tr>
                <tr>
                  <td>
                    <a href="#">스터디 2주차</a>
                  </td>
                  <td>6기 최부엉</td>
                  <td>2021.07.03</td>
                </tr>
                <tr>
                  <td>
                    <a href="#">스터디 1주차</a>
                  </td>
                  <td>6기 최부엉</td>
                  <td>2021.07.01</td>
                </tr>
              </table>
            </div>
            <div className={style["main__page-box"]}>
              <a href="#" className={style["main__page-box-number"]}>
                1
              </a>
            </div>
          </React.Fragment>
        );
    }
}

export default ReadStudyActivityList;
